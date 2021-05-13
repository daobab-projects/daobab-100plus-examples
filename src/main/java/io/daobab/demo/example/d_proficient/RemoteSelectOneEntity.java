package io.daobab.demo.example.d_proficient;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote select One Entity
 * ---------------------------------------------------------
 * - How to select entity remotely
 */
@Component
public class RemoteSelectOneEntity extends ServiceBase<Film> {


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
