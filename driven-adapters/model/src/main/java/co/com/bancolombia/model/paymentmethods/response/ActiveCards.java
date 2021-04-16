package co.com.bancolombia.model.paymentmethods.response;

import co.com.bancolombia.model.apiconnect.response.Errors;
import co.com.bancolombia.model.apiconnect.response.Links;
import co.com.bancolombia.model.apiconnect.response.Meta;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActiveCards implements Serializable {
    private static final long serialVersionUID = 2526264617231297332L;
    private Meta meta;
    private List<PaymentMethodsData> data;
    private Links links;
    private List<Errors> errors;
}
