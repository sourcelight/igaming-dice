/**
 * @author: Riccardo_Bruno
 * @project: igaming-dice
 */
package com.example.igaming.actuator;


import com.example.igaming.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DatabaseReactiveHealthIndicator implements ReactiveHealthIndicator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<Health> health() {
        return userRepository.count()
                .map(count -> Health.up().withDetail("database", "Available").build())
                .onErrorResume(ex -> Mono.just(Health.down(ex).withDetail("database", "Unavailable").build()));
    }
}
