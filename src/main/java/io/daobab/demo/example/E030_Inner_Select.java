package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Inner Select
 * ---------------------------------------------------------
 * - How to use inner selects
 */
@Component
public class E030_Inner_Select extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var rv = way01();
        rv.forEach(r -> log.info(r.toString()));
        return rv;
    }


    public FlatPlates way01() {

        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .whereIn(c.colAddressId(),
                        db.select(a.colAddressId()).whereEqual(a.colPostalCode(), "85505"))
                .findManyAsFlat();

    }


}
