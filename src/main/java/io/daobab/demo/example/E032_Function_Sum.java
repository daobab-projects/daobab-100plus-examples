package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.sum;

/**
 * ---------------------------------------------------------
 * Sum
 * ---------------------------------------------------------
 * - How to use function Sum
 */
@Component
public class E032_Function_Sum extends ServiceBase<List<Double>> {

    @Override
    public List<Double> call() {
        return db.select(sum(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
