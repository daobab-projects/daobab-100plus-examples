package io.daobab.demo.example.d_proficient;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK method - find related Entities with many to many cross table
 * ---------------------------------------------------------
 * - How to use PK method to find selected related entity, through cross table. Relation ManyToMany.
 */
@Component
public class PrimaryKeyFindManyToManyRelated extends ServiceBase<Entities<Actor>> {

    @Override
    public Entities<Actor> call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        return film.findRelatedManyByCross(db, tabFilmActor, tabActor);
    }


}
