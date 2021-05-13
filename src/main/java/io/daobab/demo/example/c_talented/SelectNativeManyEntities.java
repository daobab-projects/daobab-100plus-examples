package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native Many Entities
 * ---------------------------------------------------------
 */
@Component
public class SelectNativeManyEntities extends ServiceBase<Entities<Film>> {


    @Override
    public Entities<Film> call() {
        return db.nativeSelect("select * from film where film_id<15", tabFilm)
                .findMany();
    }


}
