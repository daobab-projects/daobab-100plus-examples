package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.column.Title;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static io.daobab.demo.dao.Lang.English;

/**
 * ---------------------------------------------------------
 * Entities Stream
 * ---------------------------------------------------------
 * - Entities is a collection, so stream operations available as well.
 */
@Component
public class EntitiesStream extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, EntitiesStream.class.getName());
    }


    @Override
    public List<String> call() {
        var en = db.select(tabLanguage)
                .whereEqual(tabLanguage.colName(), English)
                .findOne();
        var t = tabFilm;
        return db.findAll(t)
                .stream()
                .filter(f -> f.getLanguageId().equals(en.getLanguageId()))
                .filter(f -> f.getLength() > 150)
                .map(Title::getTitle)
                .collect(Collectors.toList());

    }


    public List<String> way02() {
        var en = db.select(tabLanguage)
                .whereEqual(tabLanguage.colName(), English)
                .findOne();
        var t = tabFilm;
        return db.findAll(t)
                .stream()
                .filter(f -> f.getLanguageId().equals(en.getLanguageId()))
                .filter(f -> f.getLength() > 150)
                .map(Title::getTitle)
                .collect(Collectors.toList());

    }
}
