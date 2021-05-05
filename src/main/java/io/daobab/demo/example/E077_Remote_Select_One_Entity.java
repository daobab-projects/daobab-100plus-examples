package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote select One Entity
 * ---------------------------------------------------------
 * - How to select entity remotely
 */
@Component
public class E077_Remote_Select_One_Entity extends ServiceBase<Film> {


    @Override
    public Film call() {
        return way02();
    }

    public Film way01() {
        return remote.findOneByPk(tabFilm, 1);
    }

    public Film way02() {
        return remote.select(tabFilm).whereEqual(tabFilm.colID(), 1).findOne();
    }


}
