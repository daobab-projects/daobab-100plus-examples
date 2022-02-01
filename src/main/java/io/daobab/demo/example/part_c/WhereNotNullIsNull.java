package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Payment;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Operator NotNull / IsNull
 * ---------------------------------------------------------
 */
@Component
public class WhereNotNullIsNull extends ServiceBase<Entities<Payment>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereNotNullIsNull.class.getName());
    }


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
