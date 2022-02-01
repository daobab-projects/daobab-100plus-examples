package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Plate;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Date Functions
 * ---------------------------------------------------------
 */
@Component
public class DateFunctions extends ServiceBase<Plate> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, DateFunctions.class.getName());
    }

    @Override
    public Plate call() {
        var f = tabPayment;

        return db.select(dayOfMonth(f.colPaymentDate()), month(f.colPaymentDate()), year(f.colPaymentDate()))
                .whereEqual(f.colID(), 15)
                .findOne();
    }


}
