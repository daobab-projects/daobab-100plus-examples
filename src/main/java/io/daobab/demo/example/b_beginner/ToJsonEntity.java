package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entity To JSon
 * ---------------------------------------------------------
 * - How to use internal toJSON() method into Entity
 */
@Component
public class ToJsonEntity extends ServiceBase<Void> {


    @Override
    public Void call() {
        var film = db.findOneByPk(tabFilm, 1);
        log.info(film.toJSON());
        return null;
    }


}
