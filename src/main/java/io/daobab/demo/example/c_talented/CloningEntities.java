package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entities Cloning
 * ---------------------------------------------------------
 */
@Component
public class CloningEntities extends ServiceBase<Void> {


    @Override
    public Void call() {
        var src = db.select(tabFilm)
                .whereLessOrEqual(tabFilm.colID(), 10)
                .findMany();
        var clone = src.clone();

        log.info("src size:" + src.size() + ", clone size:" + clone.size());

        return null;

    }


}
