package io.daobab.demo.example.d_proficient;

import io.daobab.demo.dao.table.FilmCategory;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * PK method - find related item
 * ---------------------------------------------------------
 * - How to use PK method to find related entity. Relation OneToOne.
 */
@Component
public class PrimaryKeyFindOneToOneRelated extends ServiceBase<FilmCategory> {

    @Override
    public FilmCategory call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);        //Find related
        return film.findRelatedOne(db, tabFilmCategory);
    }


}
