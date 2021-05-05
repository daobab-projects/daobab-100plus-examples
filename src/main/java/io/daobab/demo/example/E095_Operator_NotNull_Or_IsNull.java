package io.daobab.demo.example;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Operator NotNull or IsNull
 * ---------------------------------------------------------
 * - How to use NotNull/IsNull
 */
@Component
public class E095_Operator_NotNull_Or_IsNull extends ServiceBase<Entities<Payment>> {


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
