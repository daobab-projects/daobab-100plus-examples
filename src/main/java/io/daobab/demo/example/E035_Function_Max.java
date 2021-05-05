package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.length;
import static io.daobab.statement.Function.max;

/**
 * ---------------------------------------------------------
 * Max
 * ---------------------------------------------------------
 * - How to use function Max
 */
@Component
public class E035_Function_Max extends ServiceBase<Double> {

    @Override
    public Double call() {
        return db.select(max(length(tabFilm.colDescription())))
                .groupBy(tabFilm.colLanguageId())
                .findOne();
    }


}
