package co.com.bancolombia.apiconnect.deposit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositApiPathName {

    public static final String DEPOSIT_HEADER_MESSAGE_ID = "message-id";
    public static final String DEPOSIT_HEADER_CLIENT_ID = "x-ibm-client-id";
    public static final String DEPOSIT_HEADER_CLIENT_SECRET = "x-ibm-client-secret";
    public static final String DEPOSIT_JASON_WEB_TOKEN = "Jwt";
}
