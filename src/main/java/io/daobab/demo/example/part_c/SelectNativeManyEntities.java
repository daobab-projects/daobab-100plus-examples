package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native Many Entities
 * ---------------------------------------------------------
 */
@Component
public class SelectNativeManyEntities extends ServiceBase<Entities<Film>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectNativeManyEntities.class.getName());
    }

    @Override
    public Entities<Film> call() {
        return db.nativeSelect("select * from film where film_id<15", tabFilm)
                .findMany();
    }


}
