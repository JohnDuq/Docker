package co.com.bancolombia.model.deposit.response.listplans;

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
public class Commissions {
    private String name;
    private Long value;
    private Long freeTransactions;
    private Boolean vatFlag;
    private Long totalValue;
}
