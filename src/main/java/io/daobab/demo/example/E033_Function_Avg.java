package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.avg;


/**
 * ---------------------------------------------------------
 * Avg
 * ---------------------------------------------------------
 * - How to use function Avg
 */
@Component
public class E033_Function_Avg extends ServiceBase<List<Double>> {

    @Override
    public List<Double> call() {
        return db.select(avg(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
