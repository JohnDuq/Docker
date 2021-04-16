package co.com.bancolombia.model.usecase.response.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountPlan implements Serializable {
    
    private static final long serialVersionUID = 6819373782271276338L;
    private String accountType;
    private String numberProduct;
    private boolean electronicBankStatementFlag;
}
