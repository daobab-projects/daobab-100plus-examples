package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Count Distinct
 * ---------------------------------------------------------
 */
@Component
public class CountDistinct extends ServiceBase<Long> implements FunctionWhispererH2 {

    @Override
    public Long call() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .countBy(fieldDistinct(c.colFirstName()));
    }

    public Long way2() {
        var c = tabCustomer;
        return db
                .select(count(distinct(c.colID())))
                .whereGreater(c.colID(), 10)
                .findOne();
    }


}
