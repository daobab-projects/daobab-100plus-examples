package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native One Cell
 * ---------------------------------------------------------
 * - How to use Select Native One Cell
 */
@Component
public class E088_Select_Native_One_Entity extends ServiceBase<Film> {


    @Override
    public Film call() {
        return db.nativeSelect("select * from film where film_id=15", tabFilm)
                .findOne();
    }


}
