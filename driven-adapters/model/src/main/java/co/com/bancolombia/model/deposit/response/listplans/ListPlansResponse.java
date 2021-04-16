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
public class ListPlansResponse {
    private Long responseSize;
    private Boolean flagMoreRecords;
    private Plan plan;
    private Account account;
    private Customer customer;
    private Category category;
    private Commissions commissions;
    private InterestPayment interestPayment;
}
