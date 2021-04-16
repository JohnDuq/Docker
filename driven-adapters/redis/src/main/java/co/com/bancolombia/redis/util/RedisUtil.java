package co.com.bancolombia.redis.util;

import co.com.bancolombia.logging.technical.LoggerFactory;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import co.com.bancolombia.model.pricing.common.PricingLabel;
import co.com.bancolombia.model.redis.gateway.RedisObject;
import co.com.bancolombia.util.StringUtil;
import reactor.core.publisher.Mono;

import java.util.StringJoiner;

public class RedisUtil {

    private final TechLogger techLogger = LoggerFactory.getLog(getClass().getName());

    public Mono<RedisObject> warnRedis(String messageId, String key, String action, Exception exception) {
        techLogger.warn(new StringJoiner(PricingLabel.SPACE)
                .add(PricingLabel.PRICING)
                .add(PricingLabel.EXCEPTION)
                .add(action)
                .add(PricingLabel.MESSAGE_ID.concat(PricingLabel.DOUBLE_POINT).concat(messageId))
                .add(PricingLabel.REDIS.concat(PricingLabel.DOUBLE_POINT).concat(key))
                .add(PricingLabel.MESSAGE.concat(PricingLabel.DOUBLE_POINT).concat(PricingLabel.SPACE)
                        .concat(StringUtil.exceptionStackTraceToString(exception))));
        return Mono.just(new RedisObject(key, null));
    }

}
