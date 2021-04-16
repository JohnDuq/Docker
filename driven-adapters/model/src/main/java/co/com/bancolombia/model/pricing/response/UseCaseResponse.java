package co.com.bancolombia.model.pricing.response;

import co.com.bancolombia.model.apiconnect.response.ApiConnectResponse;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import lombok.*;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UseCaseResponse implements Serializable {
    private static final long serialVersionUID = 8656444849946799940L;
    private String messageId;
    private ApiConnectResponse apiConnectResponse;
    private DynamoDbResponseUC dynamoDbResponse;
}
