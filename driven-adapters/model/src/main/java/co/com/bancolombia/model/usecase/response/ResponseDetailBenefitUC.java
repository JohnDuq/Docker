package co.com.bancolombia.model.usecase.response;

import co.com.bancolombia.model.dynamodb.response.DynamoDbResponseUC;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDetailBenefitUC implements Serializable {

    private static final long serialVersionUID = -7024251145521675080L;
    private DynamoDbResponseUC dynamoDbResponse;

}
