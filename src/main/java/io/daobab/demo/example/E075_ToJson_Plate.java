package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Plate To JSon
 * ---------------------------------------------------------
 * - How to use internal toJSON() method into Plate
 */
@Component
public class E075_ToJson_Plate extends ServiceBase<FlatPlates> {


    @Override
    public FlatPlates call() {
        var film = db.select(tabFilm.colTitle(), tabFilm.colDescription()).whereLess(tabFilm.colID(), 10).findManyAsFlat();
        log.info(film.toJSON());
        return film;
    }


}
