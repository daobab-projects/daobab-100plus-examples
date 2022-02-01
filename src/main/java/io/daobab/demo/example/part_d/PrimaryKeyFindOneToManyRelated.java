package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK method - find related items
 * ---------------------------------------------------------
 * - How to use PK method to find related entities. Relation OneToMany.
 */
@Component
public class PrimaryKeyFindOneToManyRelated extends ServiceBase<Entities<FilmActor>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyFindOneToManyRelated.class.getName());
    }

    @Override
    public Entities<FilmActor> call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        return film.findRelatedMany(db, tabFilmActor);
    }


}
