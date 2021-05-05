package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.*;

/**
 * ---------------------------------------------------------
 * Date Functions
 * ---------------------------------------------------------
 * - How to use Date Functions
 */
@Component
public class E092_Date_Functions extends ServiceBase<Plate> {


    @Override
    public Plate call() {
        var f = tabPayment;

        return db.select(day(f.colPaymentDate()), month(f.colPaymentDate()), year(f.colPaymentDate()))
                .whereEqual(f.colID(), 15)
                .findOne();
    }


}
