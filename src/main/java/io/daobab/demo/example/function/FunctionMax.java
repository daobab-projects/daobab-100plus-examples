package io.daobab.demo.example.function;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Max
 * ---------------------------------------------------------
 */
@Component
public class FunctionMax extends ServiceBase<Integer> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FunctionMax.class.getName());
    }

    @Override
    public Integer call() {
        return db.select(max(length(tabFilm.colDescription())))
                .groupBy(tabFilm.colLanguageId())
                .findOne();
    }


}
