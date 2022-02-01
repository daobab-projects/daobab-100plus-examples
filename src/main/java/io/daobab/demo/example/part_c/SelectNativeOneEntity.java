package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native One Cell
 * ---------------------------------------------------------
 */
@Component
public class SelectNativeOneEntity extends ServiceBase<Film> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectNativeOneEntity.class.getName());
    }

    @Override
    public Film call() {
        return db.nativeSelect("select * from film where film_id=15", tabFilm)
                .findOne();
    }


}
