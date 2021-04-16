
package co.com.bancolombia.model.dynamodb.response.localstack;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Charge implements Serializable {
    private static final long serialVersionUID = 4642488213694928062L;
    private String labelPayment;
    private Double payment;
}
