package co.com.bancolombia.apiconnect.paymentmethods;

import co.com.bancolombia.model.paymentmethods.gateway.PaymentMethodsGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PayMethApiClientConfigLocalStack {

    @Bean
    @Primary
    public PaymentMethodsGateway buildPaymentMethodsGateway() {
        return new PaymentMethodsApiClientLocalStack();
    }

}
