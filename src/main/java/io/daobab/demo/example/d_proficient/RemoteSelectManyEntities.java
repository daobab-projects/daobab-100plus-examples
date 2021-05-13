package io.daobab.demo.example.d_proficient;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Many Entities
 * ---------------------------------------------------------
 * - How to select many entities remotely
 */
@Component
public class RemoteSelectManyEntities extends ServiceBase<Entities<Film>> {


    @Override
    public Entities<Film> call() {
        var t = tabFilm;
        return remote.select(t).whereLess(t.colID(), 30).findMany();
    }


}
