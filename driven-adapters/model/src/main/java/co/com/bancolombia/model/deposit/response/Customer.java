package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 4141362798342253622L;
    private Identification identification;
    private String name;
}
