package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entities To JSon
 * ---------------------------------------------------------
 * - How to use internal toJson() method into Entities
 */
@Component
public class ToJsonEntities extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ToJsonEntities.class.getName());
    }

    @Override
    public Void call() {
        var film = db
                .select(tabFilm)
                .whereLess(tabFilm.colID(), 10)
                .findMany();
        log.info(film.toJson());
        return null;
    }


}
