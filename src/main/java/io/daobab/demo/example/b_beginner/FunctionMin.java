package io.daobab.demo.example.b_beginner;

import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Min
 * ---------------------------------------------------------
 */
@Component
public class FunctionMin extends ServiceBase<Integer> implements FunctionWhispererH2 {

    @Override
    public Integer call() {
        return db.select(min(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findOne();
    }

    public FilmActor call2() {
        return db.selectRelated(tabFilm, tabFilmActor).findOne();
    }


}
