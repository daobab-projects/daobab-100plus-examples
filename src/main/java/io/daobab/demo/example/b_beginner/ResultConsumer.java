package io.daobab.demo.example.b_beginner;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use Result Consumer
 * ---------------------------------------------------------
 */
@Component
public class ResultConsumer extends ServiceBase<Void> {

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
