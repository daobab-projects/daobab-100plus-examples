package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.demo.example.model.PaymentDateWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Result Mapper
 * ---------------------------------------------------------
 * - How to use mapper
 */
@Component
public class E056_Result_Mapper extends ServiceBase<List<PaymentDateWrapper>> {

    @Override
    public List<PaymentDateWrapper> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .map(e -> new PaymentDateWrapper(e.getAmount(), e.getPaymentDate()))
                .findMany();
    }


}


