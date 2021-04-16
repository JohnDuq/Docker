package co.com.bancolombia.model.paymentmethods.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Cards {
    private CardType cardType;
    private String bin;
    private String urlImage;
    private CustomerCard customerCard;
}
