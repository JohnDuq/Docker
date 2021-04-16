package co.com.bancolombia.model.paymentmethods.response.debitcardcost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Agreement {
    private Long collectionGroupValue;
    private Long amountCompany;
}
