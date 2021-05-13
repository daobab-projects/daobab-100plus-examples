package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Get All Entities
 * ---------------------------------------------------------
 * - How to get all entities without any conditions
 * ---------------------------------------------------------
 * - Entities class is a List instance
 * - Entities may be used as a In-Memory Target
 */
@Component
public class SelectAll extends ServiceBase<Entities<Actor>> {

    //Classic usage - no 'where' clause
    @Override
    public Entities<Actor> call() {
        return db.select(tabActor).findMany();
    }

    //Shortest usage with 'findAll' method
    public Entities<Actor> scenario02() {
        return db.findAll(tabActor);
    }
}
