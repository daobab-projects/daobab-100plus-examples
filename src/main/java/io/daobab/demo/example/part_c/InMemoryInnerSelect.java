package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import org.springframework.boot.SpringApplication;
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
public class InMemoryInnerSelect extends ServiceBase<List<Film>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, InMemoryInnerSelect.class.getName());
    }

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
