package io.daobab.demo.example.a_novice;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Plate;
import io.daobab.result.Plates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to get specified columns as a list
 * ---------------------------------------------------------
 */
@Component
public class ManyPlatesManyTables extends ServiceBase<Plates> {

    @Override
    public Plates call() {
        return way01();
    }


    public Plates way01() {
        var t = tabCustomer;
        var rv = db.select(t.colFirstName(), t.colLastName())
                .whereEqual(t.colActive(), true)
                .orderAscBy(t.colLastName())
                .findMany();

        logResult(rv, t.colFirstName(), t.colLastName());
        return rv;
    }

    private void logResult(Plates plates, Column<?, ?, ?>... col) {
        for (var plate : plates) {
            logResult(plate, col);
        }
    }

    private void logResult(Plate plate, Column<?, ?, ?>... col) {
        for (var c : col) {
            log.info("entity:" + c.getEntityName() + ",column:" + c.getColumnName() + ",value:" + plate.getValue(c));
        }
    }

}
