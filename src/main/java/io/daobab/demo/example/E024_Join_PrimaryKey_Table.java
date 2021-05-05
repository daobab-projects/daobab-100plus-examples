package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Table by PrimaryKey
 * ---------------------------------------------------------
 * - How to join table by their PK
 */
@Component
public class E024_Join_PrimaryKey_Table extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .joinPk(a)
                .findManyAsFlat();
    }


}
