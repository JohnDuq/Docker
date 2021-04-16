package co.com.bancolombia.apiconnect.deposit;

import co.com.bancolombia.model.deposit.gateway.DepositGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DepositApiClientConfigLocalStack {

    @Bean
    @Primary
    public DepositGateway buildDepositApiClient() {
        return new DepositApiClientLocalStack();
    }

}
