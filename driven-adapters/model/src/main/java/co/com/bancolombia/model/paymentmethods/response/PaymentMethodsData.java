package co.com.bancolombia.model.paymentmethods.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodsData implements Serializable {
    private static final long serialVersionUID = 2248178747450352872L;
    private String messageId;
    private List<Cards> cardsList;
}
