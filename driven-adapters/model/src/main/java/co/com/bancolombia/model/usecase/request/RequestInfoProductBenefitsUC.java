package co.com.bancolombia.model.usecase.request;

import co.com.bancolombia.model.usecase.request.model.Identification;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestInfoProductBenefitsUC implements Serializable {
    private static final long serialVersionUID = 6235023678309190430L;
    private Identification identification;
}
