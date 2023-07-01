package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Payment;
import io.daobab.parser.ParserGeneral;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use Result Consumer
 * ---------------------------------------------------------
 */
@Component
public class ResultConsumer extends ServiceBase<Void> implements ParserGeneral {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ResultConsumer.class.getName());
    }

    @Override
    public Void call() {
        db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .findMany()
                .forEach(this::resultConsumer);
        return null;
    }

    private void resultConsumer(Payment payment) {
        log.info("amount: " + payment.getAmount() + " received at " + payment.getPaymentDate());
    }

}
