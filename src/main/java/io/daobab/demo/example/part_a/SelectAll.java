package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import io.daobab.target.buffer.single.Entities;
import io.daobab.target.database.query.DataBaseQueryBase;
import io.daobab.target.database.query.frozen.FrozenDataBaseQueryEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.Period;
import java.util.List;

import static io.daobab.target.database.query.frozen.DaoParam.param;

/**
 * ---------------------------------------------------------
 * Get All Entities
 * ---------------------------------------------------------
 * - How to get all entities without any conditions
 * ---------------------------------------------------------
 * - Entities class is a List instance
 * - Entities may be used as an In-Memory Target
 */
@Component
public class SelectAll extends ServiceBase<Entities<Actor>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectAll.class.getName());
    }

    FrozenDataBaseQueryEntity<Actor> prepared;

    @PostConstruct
    public void init() {
        prepared = db.select(tabActor)
                .where(and()
//                        .equal(tabActor.colID(), param(1))
//                        .notLike(tabActor.colLastName(), param(2))
                        .in(tabActor.colID(), param(1))
                        .in(tabActor.colLastName(),  param(2))
                )
//                .limitBy(param(3))
                .freezeQuery()
//                .cacheResultsForPeriod(Period.ofYears(5))
        ;

    }

    //Classic usage - no 'where' clause
    @Override
    public Entities<Actor> call() {
        return prepared
                .withParameters(List.of(List.of(1,2,3,4,5),List.of("Adam","dupa","jas")))
                .findMany();

    }

    //Shortest usage with 'findAll' method
    public Entities<Actor> scenario02() {
        return db.findAll(tabActor);
    }
}
