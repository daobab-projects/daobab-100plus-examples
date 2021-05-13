package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
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

    @Override
    public Entities<Actor> call() {
        return db.select(tabActor).whereLess(tabActor.colActorId(), 10).findMany();
    }

}
