package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to get many entities
 * ---------------------------------------------------------
 * - Entities class is a List instance
 * - Entities object is a target as well
 */
@Component
public class SelectManyEntities extends ServiceBase<Entities<Actor>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectManyEntities.class.getName());
    }

    @Override
    public Entities<Actor> call() {
        return db.select(tabActor).whereLess(tabActor.colActorId(), 10).findMany();
    }

}
