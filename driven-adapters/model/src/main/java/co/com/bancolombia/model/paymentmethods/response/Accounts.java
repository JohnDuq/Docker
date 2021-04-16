package co.com.bancolombia.model.paymentmethods.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Accounts {
    private String accountType;
    private String number;
    private Boolean isPrimary;
    private Boolean isDefault;
}
