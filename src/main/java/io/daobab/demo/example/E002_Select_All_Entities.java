package io.daobab.demo.example;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.example.base.ServiceBase;
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
public class E002_Select_All_Entities extends ServiceBase<Entities<Actor>> {

    @Override
    public Entities<Actor> call() {
        return scenario01();
    }

    //Classic usage - no 'where' clause
    public Entities<Actor> scenario01() {
        return db.select(tabActor).findMany();
    }

    //Shortest usage with 'findAll' method
    public Entities<Actor> scenario02() {
        return db.findAll(tabActor);
    }
}
