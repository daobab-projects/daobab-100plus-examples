package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native Many Entities
 * ---------------------------------------------------------
 * - How to use Select Native Many Entities
 */
@Component
public class E089_Select_Native_Many_Entities extends ServiceBase<Entities<Film>> {


    @Override
    public Entities<Film> call() {
        return db.nativeSelect("select * from film where film_id<15", tabFilm)
                .findMany();
    }


}
