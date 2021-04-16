package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Regime implements Serializable {
    private static final long serialVersionUID = -6901290007261114063L;
    private String regime;
    private String type;
}
