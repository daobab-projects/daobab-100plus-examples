package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.Lang;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * In Memory Cascade Selects
 * ---------------------------------------------------------
 */
@Component
public class InMemoryCascadeSelects extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, InMemoryCascadeSelects.class.getName());
    }

    @Override
    public List<String> call() {
        var t = tabFilm;

        var en = db.select(tabLanguage)
                .whereEqual(tabLanguage.colName(), Lang.English)
                .findOne();

        //all movies
        var allFilms = db.findAll(t);

        //english language all movies
        var englishMovies = allFilms.select(t).whereEqual(t.colLanguageId(), en).findMany();

        //english language all movies having length longer than 150 minutes
        var longEnglishMovies = englishMovies.select(t)
                .whereGreater(t.colLength(), 150)
                .findMany();
        //just ordered titles of english language all movies having length longer than 150 minutes
        return longEnglishMovies.select(t.colTitle())
                .orderAscBy(t.colTitle())
                .findMany();


    }


}
