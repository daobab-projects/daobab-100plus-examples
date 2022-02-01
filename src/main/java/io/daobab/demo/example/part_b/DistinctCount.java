package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Distinct Count
 * ---------------------------------------------------------
 */
@Component
public class DistinctCount extends ServiceBase<Long> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, DistinctCount.class.getName());
    }

    @Override
    public Long call() {
        return db.select(tabCustomer.colFirstName())
                .distinct()
                .countAny();
    }

    public Long way02() {
        return db.select(count(distinct(tabCustomer.colFirstName()))).findOne();
    }


}
