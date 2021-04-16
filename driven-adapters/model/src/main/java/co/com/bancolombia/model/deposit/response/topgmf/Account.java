package co.com.bancolombia.model.deposit.response.topgmf;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String type;
    private String number;
    private FinancialTransactionsTax financialTransactionsTax;
}
