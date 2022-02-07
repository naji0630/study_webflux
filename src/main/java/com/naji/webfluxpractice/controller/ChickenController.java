package com.naji.webfluxpractice.controller;

import com.naji.webfluxpractice.Chicken;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chicken")
public class ChickenController {

    @GetMapping
    public Flux<Chicken> findAll() {


        Chicken kyochon = new Chicken("교촌치킨", 10);
        Chicken BBQ = new Chicken("BBQ", 10);
        Chicken nene = new Chicken("네네", 10);

        Flux<Chicken> chickens = Flux.just(kyochon, BBQ, nene);

        Flux<Integer> score = Flux.range(1, 10);

        Chicken [] chickenArray = {BBQ, nene};
        Flux<Chicken> chickenFromArray = Flux.fromArray(chickenArray);

        List<Chicken> chickenList1 = new ArrayList<>();
        chickenList1.add(kyochon);
        chickenList1.add(nene);
        Flux<Chicken> chickenFromIterable = Flux.fromIterable(chickenList1);

        List<Chicken> chickenList2 = new ArrayList<>();
        chickenList2.add(kyochon);
        chickenList2.add(BBQ);
        chickenList2.add(nene);
        Flux<Chicken> chickenFromStream = Flux.fromStream(chickenList2.stream());

        chickens
            .subscribe(x-> System.out.println("최고의 치킨은 " + x.getName() + " 이다."));




        Flux<Chicken> empty = Flux.empty();

        return null;
    }
}
