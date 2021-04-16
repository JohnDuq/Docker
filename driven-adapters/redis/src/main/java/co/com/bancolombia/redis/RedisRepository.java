package co.com.bancolombia.redis;

import co.com.bancolombia.model.pricing.common.PricingLabel;
import co.com.bancolombia.model.redis.gateway.RedisGateway;
import co.com.bancolombia.model.redis.gateway.RedisObject;
import co.com.bancolombia.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class RedisRepository implements RedisGateway {

    private final RedisUtil redisUtil = new RedisUtil();
    private final ReactiveRedisOperations<String, String> reactiveRedisOperations;
    @Value("#{environment.APP_REDIS_DURATION_SECONDS}")
    private Long appRedisDurationSeconds;

    @Override
    public Mono<RedisObject> save(String messageId, RedisObject redisObject) {
        return Mono.just(redisObject.getKey())
                .flatMap(rObject -> reactiveRedisOperations.opsForValue()
                        .set(redisObject.getKey(), redisObject.getValue(), Duration.ofSeconds(appRedisDurationSeconds)))
                .map(saved -> redisObject)
                .onErrorResume(Exception.class, error ->
                        redisUtil.warnRedis(messageId, redisObject.getKey(), PricingLabel.SAVED, error));
    }

    @Override
    public Mono<RedisObject> findByKey(String messageId, String key) {
        return reactiveRedisOperations.opsForValue()
                .get(key)
                .map(result -> new RedisObject(key, result))
                .switchIfEmpty(Mono.just(new RedisObject(key, null)))
                .onErrorResume(Exception.class, error -> redisUtil.warnRedis(messageId, key,
                        PricingLabel.RESPONSE, error));
    }

}
