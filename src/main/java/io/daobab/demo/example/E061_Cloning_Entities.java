package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entities Cloning
 * ---------------------------------------------------------
 * - How to use Entities cloning
 */
@Component
public class E061_Cloning_Entities extends ServiceBase<Void> {


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
