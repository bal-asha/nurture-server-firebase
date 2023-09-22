package org.org.bal.asha.app.server.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping("/nurture")
public class NurtureController {
    @GetMapping
    public Flux<String> health() {
        return Flux.fromStream(Stream.generate(()->  "Healthy at "+ LocalDateTime.now() +"\n").limit(10));
    }
}
