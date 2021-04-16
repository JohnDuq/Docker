package co.com.bancolombia.model.usecase.request;

import co.com.bancolombia.model.usecase.request.model.Identification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDetailProductInformationUC implements Serializable {
    private static final long serialVersionUID = -712151841975055400L;
    private Identification identification;
}
