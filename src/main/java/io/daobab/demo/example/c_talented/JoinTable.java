package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Table
 * ---------------------------------------------------------
 * - How to join tables by the same column (PK,FK)
 */
@Component
public class JoinTable extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .join(a, c.colAddressId())
                .findManyAsFlat();
    }


}
