package io.daobab.demo.example.e_expert;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * ---------------------------------------------------------
 * Eager Loading
 * ---------------------------------------------------------
 * - How to use related objects Eager Loading
 */
@Component
public class EagerLoading extends ServiceBase<List<Payment>> {

    @Override
    public List<Payment> call() {
        var rv = db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .findMany();
        rv.forEach(this::resultPostProcessor);
        return rv;
    }

    private void resultPostProcessor(Payment payment) {
        payment.put("relatedCustomer", payment.findRelatedOne(db, tabCustomer));
        //OR
//        payment.put("relatedCustomer",Select.oneByPK(db,tabCustomer,payment.getCustomerId()));
    }

}
