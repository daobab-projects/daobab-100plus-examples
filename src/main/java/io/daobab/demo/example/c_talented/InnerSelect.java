package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Inner Select
 * ---------------------------------------------------------
 * - How to use inner selects
 */
@Component
public class InnerSelect extends ServiceBase<FlatPlates> {

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
