package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Operator NotNull / IsNull
 * ---------------------------------------------------------
 */
@Component
public class WhereNotNullIsNull extends ServiceBase<Entities<Payment>> {


    @Override
    public Entities<Payment> call() {
        var p = tabPayment;

        return db.select(p)
                .where(and()
                        .notNull(p.colPaymentDate())
                        .isNull(p.colAmount()))
                .limitBy(5)
                .findMany();
    }


}
