package co.com.bancolombia.dynamodb.util;

import co.com.bancolombia.logging.technical.LoggerFactory;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import co.com.bancolombia.model.dynamodb.response.localstack.Tab;
import co.com.bancolombia.model.pricing.common.PricingLabel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

import javax.json.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static co.com.bancolombia.util.StringUtil.exceptionStackTraceToString;

public class DynamoDBAdapterUtil {

    private final TechLogger techLogger = LoggerFactory.getLog(getClass().getName());
    private final DynamoDBMapperUtil dynamoDBMapperUtil = new DynamoDBMapperUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private String messageId;

    public static final int UNIQUE_VALUE = 0;
    public static final String PANTALLA = ":pantalla";
    public static final String KEY_CONDITION_EXPRESSION_UNIQUE = " pantalla = ".concat(PANTALLA);

    public DynamoDBAdapterUtil() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Mono<DynamoDbResponseUC> queryResponseToDynamoDbResponseUC(String messageId, QueryResponse queryResponse) {
        this.messageId = messageId;
        return Mono.just(queryResponse)
                .flatMap(qr -> qr.count() < 1 ? Mono.just(new HashMap<String, AttributeValue>())
                        : Mono.just(qr.items().get(UNIQUE_VALUE)))
                .map(this::toJson)
                .map(this::jsonObjectToDynamoDbResponseUC);
    }

    public JsonObject toJson(Map<String, AttributeValue> attributeValues) {
        return dynamoDBMapperUtil.mapToJson(attributeValues);
    }

    public DynamoDbResponseUC jsonObjectToDynamoDbResponseUC(JsonObject jsonObject) {
        try {
            return new DynamoDbResponseUC(objectMapper.readValue(jsonObject.toString(), Tab.class));
        } catch (JsonProcessingException e) {
            techLogger.error(new StringJoiner(PricingLabel.SPACE)
                    .add(PricingLabel.PRICING)
                    .add(PricingLabel.JSONOBJECT_DYNAMODBRESPONSEUC)
                    .add(PricingLabel.RESPONSE.concat(PricingLabel.DOUBLE_POINT).concat(this.messageId))
                    .add(PricingLabel.MESSAGE.concat(PricingLabel.DOUBLE_POINT).concat(PricingLabel.SPACE)
                            .concat(exceptionStackTraceToString(e))));
            return new DynamoDbResponseUC();
        }
    }

    public Map<String, AttributeValue> buildIdDataRequest(String pantalla) {
        AttributeValue attributeValue = AttributeValue.builder().s(pantalla).build();
        Map<String, AttributeValue> map = new HashMap<>();
        map.put(PANTALLA, attributeValue);
        return map;
    }

}
