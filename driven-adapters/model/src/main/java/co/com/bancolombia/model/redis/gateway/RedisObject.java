package co.com.bancolombia.model.redis.gateway;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RedisObject implements Serializable {
    private static final long serialVersionUID = -210890579396775239L;
    private String key;
    private String value;
}
