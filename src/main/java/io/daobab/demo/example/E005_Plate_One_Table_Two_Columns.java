package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Plate One Table One Row
 * ---------------------------------------------------------
 * - How to get specified columns only. This example reads column from single row of particular table
 * ---------------------------------------------------------
 * - in this example, Plate may be easily replaced by related Entity.
 *
 * @see E006_Plate_As_Entity
 * - Plate may be used for many table results, but always represents one row of data.
 */
@Component
public class E005_Plate_One_Table_Two_Columns extends ServiceBase<Plate> {

    @Override
    public Plate call() {
        return way01();
    }

    //Only one (or fist) result can be returned
    public Plate way01() {
        var t = tabCustomer;

        var rv = db.select(t.colFirstName(), t.colLastName())
                .where(and()
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON"))
                .findOne();

        logResult(rv, t.colFirstName(), t.colLastName());
        return rv;

    }

    private void logResult(Plate plate, Column<?, ?, ?>... col) {
        for (var c : col) {
            log.info("entity:" + c.getEntityName() + ",column:" + c.getColumnName() + ",value:" + plate.getValue(c));
        }
    }

}
