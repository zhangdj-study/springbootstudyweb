package com.neusiri.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author zhangdj
 * @date 2020-07-20 16:34
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.down().withDetail("msg","服务异常").build();
    }
}
