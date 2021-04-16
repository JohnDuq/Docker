package co.com.bancolombia.model.deposit.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private String type;
    private Long number;
}
