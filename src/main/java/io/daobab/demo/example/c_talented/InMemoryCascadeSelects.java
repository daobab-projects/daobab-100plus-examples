package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.Lang;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * In Memory Cascade Selects
 * ---------------------------------------------------------
 */
@Component
public class InMemoryCascadeSelects extends ServiceBase<List<String>> {

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
