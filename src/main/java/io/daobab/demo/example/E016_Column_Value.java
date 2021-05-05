package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select One Cell
 * ---------------------------------------------------------
 * - How to get single value from particular column
 */
@Component
public class E016_Column_Value extends ServiceBase<String> {

    @Override
    public String call() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .whereEqual(c.colID(), 10)
                .findOne();
    }


}
