package co.com.bancolombia.model.deposit.response.topgmf;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FinancialTransactionsTax {
    private Boolean exemptionFlag;
    private String customerType;
    private Long capValue;
    private Long exemptionPercentage;
    private Long accumulatedDebitValue;
    private Long remainingDebitValue;
    private Long exonerateDate;
    private Long chargeDate;
    private String exonerateReason;
    private String chargeReason;
}
