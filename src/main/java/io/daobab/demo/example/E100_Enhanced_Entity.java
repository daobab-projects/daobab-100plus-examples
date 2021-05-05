package io.daobab.demo.example;

import io.daobab.demo.dao.table.enhanced.EnglishFilm;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Enhanced Entity
 * ---------------------------------------------------------
 * - How to enhance Entity (see into EnglishFilm entity)
 */
@Component
public class E100_Enhanced_Entity extends ServiceBase<Entities<EnglishFilm>> {


    @Override
    public Entities<EnglishFilm> call() {
        var t = tabEnglishFilm;
        return db.select(t)
                .whereNotNull(t.colTitle())
                .findMany();
    }


}
