package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Many Entities
 * ---------------------------------------------------------
 * - How to select many entities remotely
 */
@Component
public class E078_Remote_Select_Many_Entities extends ServiceBase<Entities<Film>> {


    @Override
    public Entities<Film> call() {
        var t = tabFilm;
        return remote.select(t).whereLess(t.colID(), 30).findMany();
    }


}
