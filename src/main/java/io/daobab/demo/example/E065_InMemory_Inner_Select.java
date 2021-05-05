package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.demo.dao.Lang.English;
import static io.daobab.demo.dao.Lang.French;

/**
 * ---------------------------------------------------------
 * InMemory Inner Select
 * ---------------------------------------------------------
 * - How to use InMemory Inner Select as a part of normal SQL Query going to the DataBase.
 */
@Component
public class E065_InMemory_Inner_Select extends ServiceBase<List<Film>> {


    @Override
    public List<Film> call() {
        var l = tabLanguage;
        var buffer = db.findAll(l);
        var t = tabFilm;
        //Notice, the main query, going to real database, has inner select result inside
        return db.select(t)
                .whereIn(t.colLanguageId(), buffer.select(l.colID()).whereIn(l.colName(), English, French))
                .findMany();

    }


}
