package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepositData implements Serializable {
    private static final long serialVersionUID = 5284963060468918650L;
    private Header header;
    private Account account;
}
