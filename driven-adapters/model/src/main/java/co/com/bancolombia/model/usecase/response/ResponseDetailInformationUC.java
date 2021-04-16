package co.com.bancolombia.model.usecase.response;

import co.com.bancolombia.model.apiconnect.response.ApiConnectResponse;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDetailInformationUC implements Serializable {

    private static final long serialVersionUID = -7024251145521675080L;
    private ApiConnectResponse apiConnectResponse;
    private DynamoDbResponseUC dynamoDbResponse;

}
