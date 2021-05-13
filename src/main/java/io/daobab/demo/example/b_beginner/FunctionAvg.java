package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.avg;


/**
 * ---------------------------------------------------------
 * Avg
 * ---------------------------------------------------------
 */
@Component
public class FunctionAvg extends ServiceBase<List<Double>> {

    @Override
    public List<Double> call() {
        return db.select(avg(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
