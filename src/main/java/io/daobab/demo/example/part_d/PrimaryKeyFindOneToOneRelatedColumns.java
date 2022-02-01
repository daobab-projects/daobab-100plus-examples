package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.FilmActor;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK method - find just selected columns from related Entity
 * ---------------------------------------------------------
 * - How to use PK method to get just selected columns from related entity. Relation OneToOne.
 */
@Component
public class PrimaryKeyFindOneToOneRelatedColumns extends ServiceBase<FilmActor> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyFindOneToOneRelatedColumns.class.getName());
    }

    @Override
    public FilmActor call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        var t = tabFilmActor;
        return film.findRelatedOne(db, t, t.colFilmId(), t.colLastUpdate());
    }


}
