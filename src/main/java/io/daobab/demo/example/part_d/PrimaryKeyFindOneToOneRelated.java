package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.FilmCategory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * PK method - find related item
 * ---------------------------------------------------------
 * - How to use PK method to find related entity. Relation OneToOne.
 */
@Component
public class PrimaryKeyFindOneToOneRelated extends ServiceBase<FilmCategory> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyFindOneToOneRelated.class.getName());
    }

    @Override
    public FilmCategory call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);        //Find related
        return film.findRelatedOne(db, tabFilmCategory);
    }


}
