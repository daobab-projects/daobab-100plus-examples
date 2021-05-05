package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Table
 * ---------------------------------------------------------
 * - How to join tables by the same column (PK,FK)
 */
@Component
public class E023_Join_Table extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .join(a, c.colAddressId())
                .findManyAsFlat();
    }


}
