package io.daobab.demo.example;

import io.daobab.demo.dao.column.Title;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static io.daobab.demo.dao.Lang.English;

/**
 * ---------------------------------------------------------
 * InMemory Filter and Map
 * ---------------------------------------------------------
 * - Entities are also a collection, so filtering and mapping available as well.
 */
@Component
public class E064_InMemory_Filter_And_Map extends ServiceBase<List<String>> {


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
                .map(f -> f.getTitle())
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
