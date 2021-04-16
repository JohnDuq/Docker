package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Identification implements Serializable {
    private static final long serialVersionUID = 4378865278334232241L;
    private String type;
    private Integer number;
}
