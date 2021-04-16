package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Header implements Serializable {
    private static final long serialVersionUID = 2473337650696508721L;
    private String type;
    private String id;
}
