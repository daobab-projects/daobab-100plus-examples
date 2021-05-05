package io.daobab.demo.example;

import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK method - find just selected columns from related Entity
 * ---------------------------------------------------------
 * - How to use PK method to get just selected columns from related entity. Relation OneToOne.
 */
@Component
public class E041_PrimaryKey_Find_OneToOne_Related_Columns extends ServiceBase<FilmActor> {

    @Override
    public FilmActor call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        var t = tabFilmActor;
        return film.findRelatedOne(db, t, t.colFilmId(), t.colLastUpdate());
    }


}
