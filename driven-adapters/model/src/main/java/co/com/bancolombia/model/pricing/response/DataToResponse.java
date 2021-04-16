package co.com.bancolombia.model.pricing.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataToResponse {
    private FinancialTransactionsTax financialtransactionstax;
}
