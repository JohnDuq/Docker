package co.com.bancolombia.dynamodb;


import co.com.bancolombia.dynamodb.repository.impl.DynamoDbGatewayImpl;
import co.com.bancolombia.dynamodb.util.DynamoDBAdapterUtil;
import co.com.bancolombia.model.dynamodb.request.DynamoDbRequestUC;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

public class DynamoDbGatewayImplTest {

    public static final String PANTALLA = "PANTALLA";
    public static final String MESSAGE_ID = "MESSAGE_ID";
    public static final String DYNAMO_DB_ADAPTER_UTIL = "dynamoDBAdapterUtil";

    @Test
    public void getCopiesAccountDetailsDynamoDb() {
        DynamoDbAsyncClient dynamoDbAsyncClient = mock(DynamoDbAsyncClient.class);
        CompletableFuture<QueryResponse> completableFuture = CompletableFuture.supplyAsync(
                () -> QueryResponse.builder().items(buildMapStringAttributeValue()).build());
        when(dynamoDbAsyncClient.query(any(QueryRequest.class))).thenReturn(completableFuture);
        DynamoDbGatewayImpl dynamoDbGateway = new DynamoDbGatewayImpl(dynamoDbAsyncClient);
        DynamoDBAdapterUtil dynamoDBAdapterUtil = mock(DynamoDBAdapterUtil.class);
        DynamoDbResponseUC dynamoDbResponseUC = DynamoDbResponseUC.builder().build();
        Mono<DynamoDbResponseUC> mDynamoDbResponseUC = Mono.just(dynamoDbResponseUC);
        when(dynamoDBAdapterUtil.queryResponseToDynamoDbResponseUC(any(), any())).thenReturn(mDynamoDbResponseUC);
        ReflectionTestUtils.setField(dynamoDbGateway, DYNAMO_DB_ADAPTER_UTIL, dynamoDBAdapterUtil);
        StepVerifier.create(dynamoDbGateway.getCopiesAccountDetailsDynamoDb(
                DynamoDbRequestUC.builder().messageId(MESSAGE_ID).id(PANTALLA).build()))
                .expectNext(dynamoDbResponseUC)
                .expectComplete()
                .verify();
    }

    @Test
    public void getCopiesAccountDetailsDynamoDbException() {
        DynamoDbAsyncClient dynamoDbAsyncClient = mock(DynamoDbAsyncClient.class);
        CompletableFuture<QueryResponse> completableFuture = CompletableFuture.supplyAsync(
                () -> QueryResponse.builder().items(buildMapStringAttributeValue()).build());
        when(dynamoDbAsyncClient.query(any(QueryRequest.class))).thenReturn(completableFuture);
        DynamoDbGatewayImpl dynamoDbGateway = new DynamoDbGatewayImpl(dynamoDbAsyncClient);
        DynamoDBAdapterUtil dynamoDBAdapterUtil = mock(DynamoDBAdapterUtil.class);
        DynamoDbResponseUC dynamoDbResponseUC = DynamoDbResponseUC.builder().build();
        Mono<DynamoDbResponseUC> mDynamoDbResponseUC = Mono.error(new Exception());
        when(dynamoDBAdapterUtil.queryResponseToDynamoDbResponseUC(any(), any())).thenReturn(mDynamoDbResponseUC);
        ReflectionTestUtils.setField(dynamoDbGateway, DYNAMO_DB_ADAPTER_UTIL, dynamoDBAdapterUtil);
        StepVerifier.create(dynamoDbGateway.getCopiesAccountDetailsDynamoDb(
                DynamoDbRequestUC.builder().messageId(MESSAGE_ID).id(PANTALLA).build()))
                .expectNext(dynamoDbResponseUC)
                .expectComplete()
                .verify();
    }

    private Map<String, AttributeValue> buildMapStringAttributeValue(){
        return new HashMap<>();
    }

}
