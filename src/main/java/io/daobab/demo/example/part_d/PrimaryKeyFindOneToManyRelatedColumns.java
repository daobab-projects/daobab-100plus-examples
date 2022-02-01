package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.FilmActor;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * PK method - find just selected columns from related Entities
 * ---------------------------------------------------------
 * - How to use PK method to get just selected columns from related entities. Relation OneToMany.
 */
@Component
public class PrimaryKeyFindOneToManyRelatedColumns extends ServiceBase<List<FilmActor>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyFindOneToManyRelatedColumns.class.getName());
    }

    @Override
    public List<FilmActor> call() {
        //Get some Entity from DB
        var film = db.findOneByPk(tabFilm, 1);
        //Find related
        var t = tabFilmActor;
        return film.findRelatedMany(db, t, t.colFilmId(), t.colLastUpdate());
    }


}
