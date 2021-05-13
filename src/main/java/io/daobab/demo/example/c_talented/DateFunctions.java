package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.*;

/**
 * ---------------------------------------------------------
 * Date Functions
 * ---------------------------------------------------------
 */
@Component
public class DateFunctions extends ServiceBase<Plate> {


    @Override
    public Plate call() {
        var f = tabPayment;

        return db.select(day(f.colPaymentDate()), month(f.colPaymentDate()), year(f.colPaymentDate()))
                .whereEqual(f.colID(), 15)
                .findOne();
    }


}
