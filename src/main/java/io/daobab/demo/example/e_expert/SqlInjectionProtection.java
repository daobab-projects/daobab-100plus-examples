package io.daobab.demo.example.e_expert;

import io.daobab.demo.dao.table.FilmText;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * SQL Injection Protection
 * ---------------------------------------------------------
 * - Daobab protection against SQLInjection
 */
@Component
public class SqlInjectionProtection extends ServiceBase<Void> {


    @Override
    public Void call() {
        var t = tabFilmText;
        var film = new FilmText()
                .setFilmId(1)
                .setDescription(" ');  Drop table xxx; Select * from film where (film.title like '%a").update(db, t.colDescription());
        return null;
    }


}
