package io.daobab.demo.example;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ---------------------------------------------------------
 * PostProcessor
 * ---------------------------------------------------------
 * - How to use PostProcessor
 */
@Component
public class E057_Result_PostProcessor extends ServiceBase<List<Payment>> {

    private BigDecimal _200 = new BigDecimal(200);

    @Override
    public List<Payment> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .findMany()
                .stream()
                .peek(this::myPostProcess)
                .collect(Collectors.toList());
    }

    private void myPostProcess(Payment payment) {
        payment.put("amount_GT_200", payment.getAmount().compareTo(_200) > 0);
    }

}
