package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Plate;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Date Functions
 * ---------------------------------------------------------
 */
@Component
public class DateFunctions extends ServiceBase<Plate> implements FunctionWhispererH2 {


    @Override
    public Plate call() {
        var f = tabPayment;

        return db.select(dayOfMonth(f.colPaymentDate()), month(f.colPaymentDate()), year(f.colPaymentDate()))
                .whereEqual(f.colID(), 15)
                .findOne();
    }


}
