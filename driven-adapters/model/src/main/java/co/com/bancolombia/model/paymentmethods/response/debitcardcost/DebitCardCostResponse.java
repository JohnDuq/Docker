package co.com.bancolombia.model.paymentmethods.response.debitcardcost;

import co.com.bancolombia.model.apiconnect.response.Errors;
import co.com.bancolombia.model.apiconnect.response.Meta;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder(toBuilder = true)
public class DebitCardCostResponse {
    private Meta meta;
    private DebitCardCostData data;
    private List<Errors> errors;
}
