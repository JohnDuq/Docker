package co.com.bancolombia.model.usecase.request;

import co.com.bancolombia.model.usecase.request.model.AccountPlan;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestAccountPlanUC implements Serializable {
    
    private AccountPlan account;
    
}
