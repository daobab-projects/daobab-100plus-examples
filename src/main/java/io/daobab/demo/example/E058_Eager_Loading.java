package io.daobab.demo.example;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ---------------------------------------------------------
 * Eager Loading
 * ---------------------------------------------------------
 * - How to use related objects Eager Loading
 */
@Component
public class E058_Eager_Loading extends ServiceBase<List<Payment>> {

    private BigDecimal _200 = new BigDecimal(200);

    @Override
    public List<Payment> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .findMany()
                .stream()
                .peek(this::resultPostProcessor)
                .collect(Collectors.toList());
    }

    private void resultPostProcessor(Payment payment) {
        payment.put("relatedCustomer", payment.findRelatedOne(db, tabCustomer));
        //OR
//        payment.put("relatedCustomer",Select.oneByPK(db,tabCustomer,payment.getCustomerId()));
    }

}
