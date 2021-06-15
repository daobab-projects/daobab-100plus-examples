package io.daobab.demo.example.a_novice;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to count
 * ---------------------------------------------------------
 */
@Component
public class Count extends ServiceBase<Long> implements FunctionWhispererH2 {

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
