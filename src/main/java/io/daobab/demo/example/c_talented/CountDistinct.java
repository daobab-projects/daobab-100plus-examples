package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.FunctionWhisperer;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Count Distinct
 * ---------------------------------------------------------
 */
@Component
public class CountDistinct extends ServiceBase<Long> implements FunctionWhisperer {

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
                .select(countDistinct(c.colID()))
                .whereGreater(c.colID(), 10)
                .findOne();
    }


}
