package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Many Entities
 * ---------------------------------------------------------
 * - How to select many entities remotely
 */
@Component
public class RemoteSelectManyEntities extends ServiceBase<Entities<Film>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemoteSelectManyEntities.class.getName());
    }

    @Override
    public Entities<Film> call() {
        var t = tabFilm;
        return remote.select(t).whereLess(t.colID(), 30).findMany();
    }


}
