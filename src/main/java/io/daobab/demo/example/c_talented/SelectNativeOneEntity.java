package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native One Cell
 * ---------------------------------------------------------
 */
@Component
public class SelectNativeOneEntity extends ServiceBase<Film> {


    @Override
    public Film call() {
        return db.nativeSelect("select * from film where film_id=15", tabFilm)
                .findOne();
    }


}
