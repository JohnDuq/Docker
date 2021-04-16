package co.com.bancolombia.model.usecase.request.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountPlan implements Serializable {
    private static final long serialVersionUID = -674385242791015431L;
    private String type;
    private String number;
}
