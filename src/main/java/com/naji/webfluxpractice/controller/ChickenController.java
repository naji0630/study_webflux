package com.naji.webfluxpractice.controller;

import com.naji.webfluxpractice.Chicken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chicken")
public class ChickenController {

    @GetMapping
    public Flux<Chicken> findAll() {
        Flux<Chicken> chickenList = Flux.just(new Chicken("교촌", 1), new Chicken("bbq", 2), new Chicken("땅코", 3));

        return chickenList;
    }
}
