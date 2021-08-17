package com.soft.maceight.service;

import com.soft.maceight.MacEightApplication;
import com.soft.maceight.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = MacEightApplication.class)
class PlayerServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    private PlayerService service;

    @BeforeEach
    public void setup() {
        service = new PlayerService(restTemplate);
    }

    @Test
    void methodGetPairsMustWork() {
        assertThat(service.getPairs(139).size()).isEqualTo(2);
    }

    @Test
    void methodGetPairsMustFail() {
        try {
            service.getPairs(null);

            NullPointerException cause = new NullPointerException("boom!");
            Throwable throwable = new Throwable(cause);
            fail("Null pointer exception", throwable);
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    private Player playerA() {
        return Player.builder()
                .firstName("AA")
                .lastName("AA")
                .hIn(70)
                .hMeters(1.78)
                .build();
    }

    private Player playerB() {
        return Player.builder()
                .firstName("BB")
                .lastName("BB")
                .hIn(69)
                .hMeters(1.75)
                .build();
    }
}
