package co.com.bancolombia.model.apiconnect.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Meta implements Serializable {
    private static final long serialVersionUID = -854294932219943208L;
    private String _messageId;
    private String _requestTimeStamp;
    private String _applicationId;
    private Integer _responseSize;
    private Integer _version;
}
