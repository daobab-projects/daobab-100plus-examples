package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.length;
import static io.daobab.statement.Function.max;

/**
 * ---------------------------------------------------------
 * Max
 * ---------------------------------------------------------
 */
@Component
public class FunctionMax extends ServiceBase<Double> {

    @Override
    public Double call() {
        return db.select(max(length(tabFilm.colDescription())))
                .groupBy(tabFilm.colLanguageId())
                .findOne();
    }


}
