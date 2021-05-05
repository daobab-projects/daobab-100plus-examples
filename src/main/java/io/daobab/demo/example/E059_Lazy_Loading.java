package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.demo.example.model.PaymentLazyLoading;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Lazy Loading
 * ---------------------------------------------------------
 * - How to use related objects lazy loading
 */
@Component
public class E059_Lazy_Loading extends ServiceBase<List<PaymentLazyLoading>> {

    @Override
    public List<PaymentLazyLoading> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .map(this::resultCompleter)
                .findMany();
    }

    //New Entity has been created just for an example.
    //You may use completeEntity method as well
    private PaymentLazyLoading resultCompleter(Payment payment) {
        return new PaymentLazyLoading() {

            @Override
            public Customer getCustomer() {
                var rv = super.getCustomer();
                if (rv == null) {
                    rv = payment.findRelatedOne(db, tabCustomer);
                    setCustomer(rv);
                }
                return rv;
            }
        };
    }

}
