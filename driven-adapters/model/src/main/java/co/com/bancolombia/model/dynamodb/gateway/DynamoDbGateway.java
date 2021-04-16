package co.com.bancolombia.model.dynamodb.gateway;

import co.com.bancolombia.model.dynamodb.request.DynamoDbRequestUC;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import reactor.core.publisher.Mono;

public interface DynamoDbGateway {

    public Mono<DynamoDbResponseUC> getCopiesAccountDetailsDynamoDb(DynamoDbRequestUC dynamoDbRequestUC);

}
