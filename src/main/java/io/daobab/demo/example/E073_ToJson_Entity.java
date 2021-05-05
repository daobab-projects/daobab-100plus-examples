package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entity To JSon
 * ---------------------------------------------------------
 * - How to use internal toJSON() method into Entity
 */
@Component
public class E073_ToJson_Entity extends ServiceBase<Void> {


    @Override
    public Void call() {
        var film = db.findOneByPk(tabFilm, 1);
        log.info(film.toJSON());
        return null;
    }


}
