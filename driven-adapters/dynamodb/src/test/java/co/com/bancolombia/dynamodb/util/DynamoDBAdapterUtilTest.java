package co.com.bancolombia.dynamodb.util;

import co.com.bancolombia.model.dynamodb.response.localstack.Tab;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.test.StepVerifier;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

import javax.json.JsonObject;
import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class DynamoDBAdapterUtilTest {

    private DynamoDBAdapterUtil dynamoDBAdapterUtil = new DynamoDBAdapterUtil();
    private static final String PANTALLA = "PANTALLA";
    private static final String MESSAGE_ID = "MESSAGE-ID";
    private static final String JSON = "{\"pantalla\":\"id\",\"components\":[{\"description\":\"Description of " +
            "tittle\",\"tittle\":\"tittle\",\"members\":[{\"paragraph\":\"This is the description of service\"," +
            "\"charge\":{\"labelPayment\":\"Monthly amount to pay:\",\"payment\":1500.2},\"idDetail\":\"idDetai" +
            "lSubtitle\",\"subtitle\":\"Subtitle\",\"icon\":\"ICON\",\"tag\":\"TAG\",\"items\":[\"ITEM 1\",\"IT" +
            "EM 2\",\"ITEM 3\"],\"benefit\":\"Benefit for member\"}]}]}";

    @Test
    public void queryResponseToDynamoDbResponseUC() throws JsonProcessingException {

        List<Map<String, AttributeValue>> lItems = new ArrayList<>();
        Map<String, AttributeValue> items = new HashMap<>();
        lItems.add(items);
        QueryResponse queryResponse = QueryResponse.builder().count(lItems.size()).items(lItems).build();

        JsonObject jsonObject = mock(JsonObject.class);
        when(jsonObject.toString()).thenReturn(JSON);
        DynamoDBMapperUtil dynamoDBMapperUtil = mock(DynamoDBMapperUtil.class);
        when(dynamoDBMapperUtil.mapToJson(any())).thenReturn(jsonObject);

        Tab tabExpected = new Tab();

        ObjectMapper objectMapper = mock(ObjectMapper.class);
        when(objectMapper.readValue(JSON, Tab.class)).thenReturn(tabExpected);

        ReflectionTestUtils.setField(dynamoDBAdapterUtil, "dynamoDBMapperUtil", dynamoDBMapperUtil);
        ReflectionTestUtils.setField(dynamoDBAdapterUtil, "objectMapper", objectMapper);

        StepVerifier.create(dynamoDBAdapterUtil.queryResponseToDynamoDbResponseUC(MESSAGE_ID, queryResponse))
                .expectNextMatches(dynamoDbResponseUC -> dynamoDbResponseUC.getTab().equals(tabExpected))
                .expectComplete()
                .verify();
    }

    @Test
    public void queryResponseToDynamoDbResponseUCEmpty() throws JsonProcessingException {

        List<Map<String, AttributeValue>> lItems = new ArrayList<>();
        Map<String, AttributeValue> items = new HashMap<>();
        lItems.add(items);
        QueryResponse queryResponse = QueryResponse.builder().count(0).build();

        JsonObject jsonObject = mock(JsonObject.class);
        when(jsonObject.toString()).thenReturn(JSON);
        DynamoDBMapperUtil dynamoDBMapperUtil = mock(DynamoDBMapperUtil.class);
        when(dynamoDBMapperUtil.mapToJson(any())).thenReturn(jsonObject);

        Tab tabExpected = new Tab();

        ObjectMapper objectMapper = mock(ObjectMapper.class);
        when(objectMapper.readValue(JSON, Tab.class)).thenReturn(tabExpected);

        ReflectionTestUtils.setField(dynamoDBAdapterUtil, "dynamoDBMapperUtil", dynamoDBMapperUtil);
        ReflectionTestUtils.setField(dynamoDBAdapterUtil, "objectMapper", objectMapper);

        StepVerifier.create(dynamoDBAdapterUtil.queryResponseToDynamoDbResponseUC(MESSAGE_ID, queryResponse))
                .expectNextMatches(dynamoDbResponseUC -> dynamoDbResponseUC.getTab().equals(tabExpected))
                .expectComplete()
                .verify();
    }

    @Test
    public void queryResponseToDynamoDbResponseUCException() throws JsonProcessingException {

        List<Map<String, AttributeValue>> lItems = new ArrayList<>();
        Map<String, AttributeValue> items = new HashMap<>();
        lItems.add(items);
        QueryResponse queryResponse = QueryResponse.builder().count(lItems.size()).items(lItems).build();

        JsonObject jsonObject = mock(JsonObject.class);
        when(jsonObject.toString()).thenReturn(JSON);
        DynamoDBMapperUtil dynamoDBMapperUtil = mock(DynamoDBMapperUtil.class);
        when(dynamoDBMapperUtil.mapToJson(any())).thenReturn(jsonObject);

        JsonProcessingException jsonProcessingException = mock(JsonProcessingException.class);
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        when(objectMapper.readValue(JSON, Tab.class)).thenThrow(jsonProcessingException);

        ReflectionTestUtils.setField(dynamoDBAdapterUtil, "dynamoDBMapperUtil", dynamoDBMapperUtil);
        ReflectionTestUtils.setField(dynamoDBAdapterUtil, "objectMapper", objectMapper);

        StepVerifier.create(dynamoDBAdapterUtil.queryResponseToDynamoDbResponseUC(MESSAGE_ID, queryResponse))
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }

    @Test
    public void buildIdDataRequest() {
        assertNotNull(dynamoDBAdapterUtil.buildIdDataRequest(PANTALLA));
    }

}
