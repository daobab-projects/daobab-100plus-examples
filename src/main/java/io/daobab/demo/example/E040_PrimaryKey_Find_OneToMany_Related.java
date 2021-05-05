package io.daobab.demo.example;

import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK method - find related items
 * ---------------------------------------------------------
 * - How to use PK method to find related entities. Relation OneToMany.
 */
@Component
public class E040_PrimaryKey_Find_OneToMany_Related extends ServiceBase<Entities<FilmActor>> {

    @Override
    public Entities<FilmActor> call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        return film.findRelatedMany(db, tabFilmActor);
    }


}
