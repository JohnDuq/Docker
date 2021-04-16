package co.com.bancolombia.model.dynamodb.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@Getter
@ToString
public class DynamoDbRequestUC {

    private String messageId;
    private String id;

}
