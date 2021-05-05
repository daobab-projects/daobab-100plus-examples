package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entities To JSon
 * ---------------------------------------------------------
 * - How to use internal toJSON() method into Entities
 */
@Component
public class E074_ToJson_Entities extends ServiceBase<Void> {


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
