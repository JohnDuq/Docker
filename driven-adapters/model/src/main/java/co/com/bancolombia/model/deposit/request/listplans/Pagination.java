package co.com.bancolombia.model.deposit.request.listplans;

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
public class Pagination {
    private Long size;
    private Long key;
    private String statusPlan;
    private String accountPlan;
    private String customerType;
    private String categoryId;
}
