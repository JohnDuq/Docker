package co.com.bancolombia.model.pricing.secretsmanager;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SecuritySecretModel {

    private String clientId;
    private String clientSecret;
    private String jasonWebToken;

}
