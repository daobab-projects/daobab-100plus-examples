package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.FilmText;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * SQL Injection Protection
 * ---------------------------------------------------------
 * - Daobab protection against SQLInjection
 */
@Component
public class SqlInjectionProtection extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SqlInjectionProtection.class.getName());
    }

    @Override
    public Void call() {
        var t = tabFilmText;
        var film = new FilmText()
                .setFilmId(1)
                .setDescription(" ');  Drop table xxx; Select * from film where (film.title like '%a").update(db, t.colDescription());
        return null;
    }


}
