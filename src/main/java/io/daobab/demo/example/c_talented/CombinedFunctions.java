package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.length;
import static io.daobab.statement.Function.max;

/**
 * ---------------------------------------------------------
 * Combined Functions
 * ---------------------------------------------------------
 */
@Component
public class CombinedFunctions extends ServiceBase<Double> {

    @Override
    public Double call() {
        return db.select(max(length(tabFilm.colDescription())))
                .whereEqual(tabFilm.colID(), 10)
                .findOne();
    }


}
