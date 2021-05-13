package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Distinct Count
 * ---------------------------------------------------------
 */
@Component
public class DistinctCount extends ServiceBase<Long> {


    @Override
    public Long call() {
        var p = tabCustomer;

        return db.select(p.colFirstName())
                .distinct()
                .countAny();
    }


}
