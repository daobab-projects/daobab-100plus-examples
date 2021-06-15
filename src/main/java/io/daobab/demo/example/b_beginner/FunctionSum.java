package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.column.LanguageId;
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
public class FunctionSum extends ServiceBase<List<BigDecimal>> implements FunctionWhispererH2 {

    @Override
    public List<BigDecimal> call() {
        return db.select(sum(tabFilm.colLength(),BigDecimal.class))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }


}
