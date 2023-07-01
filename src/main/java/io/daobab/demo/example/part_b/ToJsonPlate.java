package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Plate To JSon
 * ---------------------------------------------------------
 * - How to use internal toJson() method into Plate
 */
@Component
public class ToJsonPlate extends ServiceBase<FlatPlates> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ToJsonPlate.class.getName());
    }


    @Override
    public FlatPlates call() {
        var film = db.select(tabFilm.colTitle(), tabFilm.colDescription()).whereLess(tabFilm.colID(), 10).findManyAsFlat();
        log.info(film.toJson());
        return film;
    }


}
