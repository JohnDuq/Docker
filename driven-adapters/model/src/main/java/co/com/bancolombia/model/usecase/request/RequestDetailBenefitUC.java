package co.com.bancolombia.model.usecase.request;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDetailBenefitUC implements Serializable {
    
    private static final long serialVersionUID = -4519054846174043676L;
    private String pantalla;
    
}
