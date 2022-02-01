package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectAll.class.getName());
    }

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
