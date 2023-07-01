package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Plate;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to get specific columns from a one row
 * ---------------------------------------------------------
 */
@Component
public class OnePlateManyTables extends ServiceBase<Plate> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, OnePlateManyTables.class.getName());
    }

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
            log.info("entity:" + c.getEntityClass().getSimpleName() + ",column:" + c.getColumnName() + ",value:" + plate.getValue(c));
        }
    }

}
