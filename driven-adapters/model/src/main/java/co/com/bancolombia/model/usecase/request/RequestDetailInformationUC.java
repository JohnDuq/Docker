package co.com.bancolombia.model.usecase.request;

import co.com.bancolombia.model.usecase.request.model.Identification;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDetailInformationUC implements Serializable {

    private static final long serialVersionUID = 6991212658157354791L;
    private String pantalla;
    private Identification identification;
    
}
