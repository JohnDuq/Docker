package co.com.bancolombia.model.usecase.response.model;

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
public class CustomerPlan implements Serializable {
    
    private static final long serialVersionUID = -8517877590443449581L;
    private Identification identification;

}
