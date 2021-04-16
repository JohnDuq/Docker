package co.com.bancolombia.model.paymentmethods.request.debitcardcost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Plan {
    private String id;
    private Long code;
}
