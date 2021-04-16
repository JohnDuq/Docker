package co.com.bancolombia.apiconnect.paymentmethods;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMethodsApiPathName {

    public static final String PAYMENT_METHODS_API = "/paymenthmethos";
    public static final String PAYMENT_METHODS_PATH = "/path";
    public static final String PAYMENT_METHODS_HEADER_MESSAGE_ID = "message-id";
    public static final String DEPOSIT_HEADER_CLIENT_ID = "x-ibm-client-id";
    public static final String DEPOSIT_HEADER_CLIENT_SECRET = "x-ibm-client-secret";
}
