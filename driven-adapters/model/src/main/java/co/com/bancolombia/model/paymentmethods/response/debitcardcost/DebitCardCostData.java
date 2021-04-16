package co.com.bancolombia.model.paymentmethods.response.debitcardcost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DebitCardCostData {
    private Agreement agreement;
    private ShareCost shareCost;
}
