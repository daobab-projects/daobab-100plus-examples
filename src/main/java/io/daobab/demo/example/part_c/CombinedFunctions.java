package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Combined Functions
 * ---------------------------------------------------------
 */
@Component
public class CombinedFunctions extends ServiceBase<Integer> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, CombinedFunctions.class.getName());
    }

    @Override
    public Integer call() {
        return db.select(max(length(tabFilm.colDescription())))
                .whereEqual(tabFilm.colID(), 10)
                .findOne();
    }


}
