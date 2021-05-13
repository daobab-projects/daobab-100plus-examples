package io.daobab.demo.example.b_beginner;

import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.min;

/**
 * ---------------------------------------------------------
 * Min
 * ---------------------------------------------------------
 */
@Component
public class FunctionMin extends ServiceBase<Double> {

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
