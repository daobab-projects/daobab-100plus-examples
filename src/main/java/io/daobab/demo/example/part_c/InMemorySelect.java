package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * InMemory Select
 * ---------------------------------------------------------
 * - How to query over InMemory Entities
 */
@Component
public class InMemorySelect extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, InMemorySelect.class.getName());
    }

    @Override
    public List<String> call() {
        var t = tabFilm;

        //Get some content... here everything from table
        var allFilms = db.findAll(t);

        //execute SQL over this content - query only for titles of movies longer than...
        return allFilms.select(t.colTitle())
                .whereGreater(t.colLength(), 150)
                .limitBy(15)
                .findMany();
    }

}
