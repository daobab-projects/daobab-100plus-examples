package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * InMemory Select
 * ---------------------------------------------------------
 * - How to query over InMemory Entities
 */
@Component
public class E062_InMemory_Select extends ServiceBase<List<String>> {


    @Override
    public List<String> call() {
        var t = tabFilm;

        //Get some content... here everything from table
        var allFilms = db.findAll(t);

        //execute SQL over this content - query only for titles of movies longer than...
        return allFilms.select(t.colTitle())
                .whereGreater(t.colLength(), 150)
                .findMany();
    }

}
