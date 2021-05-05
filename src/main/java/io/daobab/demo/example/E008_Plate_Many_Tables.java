package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Plate Over Many Tables
 * ---------------------------------------------------------
 * - How to get specific columns from many tables, for one rows
 */
@Component
public class E008_Plate_Many_Tables extends ServiceBase<Plate> {

    @Override
    public Plate call() {
        var t = tabCustomer;
        var a = tabAddress;
        var rv = db.select(t.colFirstName(), t.colLastName(), a.colAddress())
                .join(a, t.colAddressId())
                .where(and()
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON"))
                .findOne();

        logResult(rv, t.colFirstName(), t.colLastName(), a.colAddress());
        return rv;
    }

    private void logResult(Plate plate, Column<?, ?, ?>... col) {
        for (var c : col) {
            log.info("entity:" + c.getEntityName() + ",column:" + c.getColumnName() + ",value:" + plate.getValue(c));
        }
    }

}
