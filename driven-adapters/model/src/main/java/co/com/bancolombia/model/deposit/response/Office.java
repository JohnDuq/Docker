package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Office implements Serializable {
    private static final long serialVersionUID = 3185252009619373506L;
    private String code;
}
