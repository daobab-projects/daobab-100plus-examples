package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to count
 * ---------------------------------------------------------
 */
@Component
public class Count extends ServiceBase<Long> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Count.class.getName());
    }

    @Override
    public Long call() {
        return db.select(count(tabCustomer)).whereGreater(tabCustomer.colID(), 10).findOne();
    }

}
