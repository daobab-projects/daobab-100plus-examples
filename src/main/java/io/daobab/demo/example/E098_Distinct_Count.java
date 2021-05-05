package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Distinct Count
 * ---------------------------------------------------------
 * - How to use Distinct Count
 */
@Component
public class E098_Distinct_Count extends ServiceBase<Long> {


    @Override
    public Long call() {
        var p = tabCustomer;

        return db.select(p.colFirstName())
                .distinct()
                .countAny();
    }


}
