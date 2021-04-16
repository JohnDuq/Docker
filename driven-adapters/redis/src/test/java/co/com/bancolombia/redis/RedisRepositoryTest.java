package co.com.bancolombia.redis;

import co.com.bancolombia.model.redis.gateway.RedisObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.test.StepVerifier;

class RedisRepositoryTest {

    public static final String MESSAGE_ID = "MESSAGE-ID";
    public static final String VALUE = "VALUE";
    public static final String KEY = "KEY";
    public static final Long TIME_OUT = 60000l;

    @MockBean
    private ReactiveRedisOperations<String, String> reactiveRedisOperations;

    private RedisRepository redisRepository;
    private RedisObject redisObject = new RedisObject(KEY, null);

    @BeforeEach
    public void init() {
        ReactiveRedisConnectionFactory reactiveRedisConnectionFactory =
                Mockito.mock(ReactiveRedisConnectionFactory.class);
        reactiveRedisOperations = new ReactiveStringRedisTemplate(reactiveRedisConnectionFactory);
        redisRepository = new RedisRepository(reactiveRedisOperations);
        ReflectionTestUtils.setField(redisRepository, "appRedisDurationSeconds", TIME_OUT);
        redisObject = new RedisObject(KEY, VALUE);
    }

    @Test
    void saveTest() {
        StepVerifier.create(redisRepository.save(MESSAGE_ID, redisObject))
                .expectNextMatches(response -> KEY.equals(response.getKey()))
                .expectComplete()
                .verify();
    }

    @Test
    void findByKeyTest() {
        StepVerifier.create(redisRepository.findByKey(MESSAGE_ID, KEY))
                .expectNextMatches(response -> KEY.equals(response.getKey()))
                .expectComplete()
                .verify();

    }

}
