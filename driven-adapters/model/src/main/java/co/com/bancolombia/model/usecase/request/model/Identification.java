package co.com.bancolombia.model.usecase.request.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Identification implements Serializable {
    private static final long serialVersionUID = -4369956858426571359L;
    private String documentType;
    private String number;
}
