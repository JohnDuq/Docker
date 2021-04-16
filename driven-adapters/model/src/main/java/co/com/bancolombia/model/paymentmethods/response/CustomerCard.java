package co.com.bancolombia.model.paymentmethods.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerCard {
    private String number;
    private String expirationDate;
    private List<Accounts> accounts;
}
