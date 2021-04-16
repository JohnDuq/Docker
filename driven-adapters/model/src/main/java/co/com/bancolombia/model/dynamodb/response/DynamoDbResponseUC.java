package co.com.bancolombia.model.dynamodb.response;

import co.com.bancolombia.model.dynamodb.response.localstack.Tab;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DynamoDbResponseUC implements Serializable {
    private static final long serialVersionUID = -4455545495769853608L;
    private Tab tab;
}
