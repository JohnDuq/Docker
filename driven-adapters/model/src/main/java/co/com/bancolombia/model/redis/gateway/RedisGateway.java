package co.com.bancolombia.model.redis.gateway;

import reactor.core.publisher.Mono;

public interface RedisGateway {

    Mono<RedisObject> save(String messageId, RedisObject redisObject);

    Mono<RedisObject> findByKey(String messageId, String key);

}
