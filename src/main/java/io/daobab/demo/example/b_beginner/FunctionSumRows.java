package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * ---------------------------------------------------------
 * Sum
 * ---------------------------------------------------------
 */
@Component
public class FunctionSumRows extends ServiceBase<List<BigDecimal>> implements FunctionWhispererH2 {

    @Override
    public List<BigDecimal> call() {
        return db.select(sumRows(tabFilm.colRentalRate(),tabFilm.colReplacementCost()).cast(BigDecimal.class))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
