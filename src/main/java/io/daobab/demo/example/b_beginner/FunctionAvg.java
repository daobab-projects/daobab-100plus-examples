package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;



/**
 * ---------------------------------------------------------
 * Avg
 * ---------------------------------------------------------
 */
@Component
public class FunctionAvg extends ServiceBase<List<BigDecimal>> implements FunctionWhispererH2 {

    @Override
    public List<BigDecimal> call() {
        return db.select(avg(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
