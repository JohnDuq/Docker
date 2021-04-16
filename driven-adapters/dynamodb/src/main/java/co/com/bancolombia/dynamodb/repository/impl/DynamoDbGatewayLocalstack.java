package co.com.bancolombia.dynamodb.repository.impl;

import co.com.bancolombia.dynamodb.util.DynamoDBAdapterUtil;
import co.com.bancolombia.logging.technical.LoggerFactory;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import co.com.bancolombia.model.dynamodb.gateway.DynamoDbGateway;
import co.com.bancolombia.model.dynamodb.request.DynamoDbRequestUC;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class DynamoDbGatewayLocalstack implements DynamoDbGateway {

    private final TechLogger techLogger = LoggerFactory.getLog(DynamoDbGatewayImpl.class.getName());
    private final DynamoDBAdapterUtil dynamoDBAdapterUtil = new DynamoDBAdapterUtil();

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    @Value("#{environment.AWS_DYNAMODB_TABLE_NAME}")
    private String tableName;

    @Override
    public Mono<DynamoDbResponseUC> getCopiesAccountDetailsDynamoDb(DynamoDbRequestUC dynamoDbRequestUC) {
        return Mono.just(dynamoDbRequestUC)
                .flatMap(this::queryIdentificationFilterKeyUnique)
                .flatMap(qr -> dynamoDBAdapterUtil.queryResponseToDynamoDbResponseUC(
                        dynamoDbRequestUC.getMessageId(), qr));
    }

    public Mono<QueryResponse> queryIdentificationFilterKeyUnique(DynamoDbRequestUC dynamoDbRequestUC) {
        QueryRequest queryRequest = QueryRequest.builder()
                .tableName(tableName)
                .keyConditionExpression(DynamoDBAdapterUtil.KEY_CONDITION_EXPRESSION_UNIQUE)
                .expressionAttributeValues(dynamoDBAdapterUtil.buildIdDataRequest(dynamoDbRequestUC.getId()))
                .build();
        CompletableFuture<QueryResponse> response = dynamoDbAsyncClient.query(queryRequest);
        return Mono.fromFuture(response);
    }

}
