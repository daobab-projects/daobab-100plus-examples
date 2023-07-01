package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Plate;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

/**
 * ---------------------------------------------------------
 * - How to get specific columns only. This example reads column from single row of particular table
 * ---------------------------------------------------------
 * - in this example, Plate may be easily replaced by related Entity.
 * <p>
 * - Plate may be used for many table results, but always represents one row of data.
 */
@Component
public class SelectPlate extends ServiceBase<Plate> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectPlate.class.getName());
    }

    @Override
    public Plate call() {
        return way01();
    }

    //Only one (or fist) result can be returned
    public Plate way01() {
        var t = tabCustomer;

        var rv = db.select(t.colFirstName(), t.colLastName())
                .whereEqual(t.colID(), 10)
                .findOne();

        logResult(rv, t.colFirstName(), t.colLastName());
        return rv;

    }

    private void logResult(Plate plate, Column<?, ?, ?>... col) {
        for (var c : col) {
            log.info(format("entity:%s ,column:%s ,value:%s", c.getEntityClass().getSimpleName(), c.getColumnName(), plate.getValue(c)));
        }
    }

}
