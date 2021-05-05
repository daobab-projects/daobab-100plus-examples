package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * BuildIn Parsers
 * ---------------------------------------------------------
 * - How to use parsers provided
 */
@Component
public class E067_BuildIn_Parsers extends ServiceBase<List<Film>> {


    @Override
    public List<Film> call() {
        var f = tabFilm;

        Long id = 500L;
        var amount = Float.parseFloat("10.02");

        return db.select(f)
                .where(and()
                        .less(f.colFilmId(), toInteger(id))
                        .equal(f.colSpecialFeatures(), "Deleted Scenes")
                        .greater(f.colReplacementCost(), toBigDecimal(amount))
                        .greater(f.colLength(), toInteger("5"))
                        .less(f.colLastUpdate(), toTimestamp("2009-12-10", "yyyy-MM-dd"))
                )
                .orderDescBy(f.colDescription())
                .findMany();

    }


}
