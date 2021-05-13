package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TimeZone;

/**
 * ---------------------------------------------------------
 * DateTime Conversion
 * ---------------------------------------------------------
 * - How to use time parser
 */
@Component
public class DateTimeConversions extends ServiceBase<List<Film>> {


    @Override
    public List<Film> call() {
        var t = tabFilm;
        return db.select(t)
                .whereLess(t.colID(), 5)
                .map(e -> e.setLastUpdate(toTimeZone(e.getLastUpdate(), TimeZone.getTimeZone("US/Alaska"))))
                .findMany();


    }


}
