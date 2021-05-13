package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Table by PrimaryKey
 * ---------------------------------------------------------
 * - How to join table by their PK
 */
@Component
public class JoinPrimaryKeyTable extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .joinPk(a)
                .findManyAsFlat();
    }


}
