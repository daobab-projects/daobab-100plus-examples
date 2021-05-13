package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.model.PaymentDateWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to use mapper
 * ---------------------------------------------------------
 */
@Component
public class ResultMapper extends ServiceBase<List<PaymentDateWrapper>> {

    @Override
    public List<PaymentDateWrapper> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .map(e -> new PaymentDateWrapper(e.getAmount(), e.getPaymentDate()))
                .findMany();
    }


}


