package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.sum;

/**
 * ---------------------------------------------------------
 * Sum
 * ---------------------------------------------------------
 */
@Component
public class FunctionSum extends ServiceBase<List<Double>> {

    @Override
    public List<Double> call() {
        return db.select(sum(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
