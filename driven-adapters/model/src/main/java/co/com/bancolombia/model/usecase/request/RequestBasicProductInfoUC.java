package co.com.bancolombia.model.usecase.request;

import co.com.bancolombia.model.usecase.request.model.Identification;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestBasicProductInfoUC implements Serializable {
    private static final long serialVersionUID = 397344025311532580L;
    private String pantalla;
    private Identification identification;
}
