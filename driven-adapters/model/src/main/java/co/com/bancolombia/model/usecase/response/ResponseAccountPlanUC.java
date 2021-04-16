package co.com.bancolombia.model.usecase.response;

import co.com.bancolombia.model.apiconnect.response.ApiConnectResponse;
import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAccountPlanUC implements Serializable {

    private static final long serialVersionUID = 8846854246863909098L;
    private ApiConnectResponse apiConnectResponse;
    private DynamoDbResponseUC dynamoDbResponse;

}
