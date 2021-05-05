package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.length;
import static io.daobab.statement.Function.max;

/**
 * ---------------------------------------------------------
 * Combined Functions
 * ---------------------------------------------------------
 * - How to use combined functions
 */
@Component
public class E037_Combined_Functions extends ServiceBase<Double> {

    @Override
    public Double call() {
        return db.select(max(length(tabFilm.colDescription())))
                .whereEqual(tabFilm.colID(), 10)
                .findOne();
    }


}
