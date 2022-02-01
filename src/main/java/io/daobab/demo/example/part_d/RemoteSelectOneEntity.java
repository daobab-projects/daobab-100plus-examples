package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote select One Entity
 * ---------------------------------------------------------
 * - How to select entity remotely
 */
@Component
public class RemoteSelectOneEntity extends ServiceBase<Film> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemoteSelectOneEntity.class.getName());
    }


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
