package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entities To JSon
 * ---------------------------------------------------------
 * - How to use internal toJSON() method into Entities
 */
@Component
public class ToJsonEntities extends ServiceBase<Void> {


    @Override
    public Void call() {
        var film = db
                .select(tabFilm)
                .whereLess(tabFilm.colID(), 10)
                .findMany();
        log.info(film.toJSON());
        return null;
    }


}
