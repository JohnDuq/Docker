package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Specification implements Serializable {
    private static final long serialVersionUID = -1485458514537472292L;
    private String name;
    private Boolean value;
}
