package co.com.bancolombia.model.deposit.request;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepositRequest {
    private List<AccountData> data;
}
