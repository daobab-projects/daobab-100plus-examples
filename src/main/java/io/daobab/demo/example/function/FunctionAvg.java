package io.daobab.demo.example.function;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FunctionAvg.class.getName());
    }

    @Override
    public List<BigDecimal> call() {
        return db.select(avg(tabFilm.colLength()))
                .groupBy(tabFilm.colLanguageId())
                .findMany();
    }

}
