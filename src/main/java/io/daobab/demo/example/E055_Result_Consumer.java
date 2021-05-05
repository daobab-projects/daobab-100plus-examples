package io.daobab.demo.example;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Result Consumer
 * ---------------------------------------------------------
 * - How to use Result Consumer
 */
@Component
public class E055_Result_Consumer extends ServiceBase<Void> {

    @Override
    public Void call() {
        db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .forEach(this::resultConsumer);
        return null;
    }

    private void resultConsumer(Payment payment) {
        log.info("amount: " + payment.getAmount() + " received at " + payment.getPaymentDate());
    }

}
