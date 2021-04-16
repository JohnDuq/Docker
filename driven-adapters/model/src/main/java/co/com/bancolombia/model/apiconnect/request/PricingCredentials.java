package co.com.bancolombia.model.apiconnect.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PricingCredentials {
    private String clientId;
    private String clientSecret;
    private String jasonWebToken;
}
