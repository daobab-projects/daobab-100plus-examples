package io.daobab.demo.example;

import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.min;

/**
 * ---------------------------------------------------------
 * Min
 * ---------------------------------------------------------
 * - How to use function Min
 */
@Component
public class E034_Function_Min extends ServiceBase<Double> {

    @Override
    public Double call() {
        return db.select(min(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findOne();
    }

    public FilmActor call2() {
        return db.selectRelated(tabFilm, tabFilmActor).findOne();
    }


}
