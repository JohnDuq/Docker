package co.com.bancolombia.secretsmanager;

import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SecretsConfigLocalStack {

    @Bean
    @Primary
    public PricingCredentials readSecretDepositCredentialsLocalstack() {
        return new PricingCredentials(
                "c438dbed-e3f0-495e-b4de-36ded6c25721",
                "V7vC0dG1mX5wV7wQ4mY1eW6eM5eA4lD2jD1qD2yO1jV5dF1uW7",
                "JWT");
    }

}
