package co.com.bancolombia.dynamodb;

import co.com.bancolombia.dynamodb.repository.impl.DynamoDbGatewayLocalstack;
import co.com.bancolombia.model.dynamodb.gateway.DynamoDbGateway;
import co.com.bancolombia.model.pricing.common.PricingLocalstack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;

@Configuration
public class DynamoDbConfigLocalStack {

    @Bean
    @Primary
    public DynamoDbGateway buildDynamoDbGateway(DynamoDbAsyncClient dynamoDbAsyncClient) {
        return new DynamoDbGatewayLocalstack(dynamoDbAsyncClient);
    }

    @Bean
    public DynamoDbAsyncClient dynamoDbAsyncClient() {
        return DynamoDbAsyncClient.builder()
                .endpointOverride(URI.create(PricingLocalstack.HTTP_LOCALHOST_4566))
                .region(Region.US_EAST_1)
                .build();
    }

}
