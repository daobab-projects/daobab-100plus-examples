package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK method - find related Entities with many to many cross table
 * ---------------------------------------------------------
 * - How to use PK method to find selected related entity, through cross table. Relation ManyToMany.
 */
@Component
public class PrimaryKeyFindManyToManyRelated extends ServiceBase<Entities<Actor>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyFindManyToManyRelated.class.getName());
    }

    @Override
    public Entities<Actor> call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        return film.findRelatedManyByCross(db, tabFilmActor, tabActor);
    }


}
