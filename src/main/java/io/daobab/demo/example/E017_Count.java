package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.statement.FunctionWhisperer;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Count elements
 * ---------------------------------------------------------
 * - How to count records
 */
@Component
public class E017_Count extends ServiceBase<Long> implements FunctionWhisperer {

    @Override
    public Long call() {
        var c = tabCustomer;
        return db.select(c).whereGreater(c.colID(), 10).countAny();
    }

    public long count() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .countAny();
    }

    public long count3() {
        var c = tabCustomer;
        return db.select(count(c.colActive()))
                .whereGreater(c.colID(), 10)
                .findOne();
    }
}
