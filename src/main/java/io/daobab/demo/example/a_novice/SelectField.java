package io.daobab.demo.example.a_novice;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to get single value of particular column
 * ---------------------------------------------------------
 */
@Component
public class SelectField extends ServiceBase<String> {

    @Override
    public String call() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .whereEqual(c.colID(), 10)
                .findOne();
    }


}
