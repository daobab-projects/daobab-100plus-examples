package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * PK method - find selected columns from related Entities with many to many cross table
 * ---------------------------------------------------------
 * - How to use PK method to get selected columns of related entities, through cross table. Relation ManyToMany.
 */
@Component
public class PrimaryKeyFindManyToManyRelatedColumns extends ServiceBase<List<Actor>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyFindManyToManyRelatedColumns.class.getName());
    }

    @Override
    public List<Actor> call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        return film.findRelatedManyByCross(db, tabFilmActor, tabActor.colFirstName(), tabActor.colLastName());
    }


}
