package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Count Distinct
 * ---------------------------------------------------------
 */
@Component
public class CountDistinct extends ServiceBase<Long> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, CountDistinct.class.getName());
    }

    @Override
    public Long call() {
        var c = tabCustomer;
        return db.select(count(distinct(c.colFirstName())))
                .whereGreater(c.colID(), 10)
                .findOne();
    }



}
