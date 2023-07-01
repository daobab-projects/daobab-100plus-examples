package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Payment;
import io.daobab.parser.ParserGeneral;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ---------------------------------------------------------
 * Eager Loading
 * ---------------------------------------------------------
 * - How to use related objects Eager Loading
 */
@Component
public class EagerLoading extends ServiceBase<List<Payment>> implements ParserGeneral {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, EagerLoading.class.getName());
    }

    @Override
    public List<Payment> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .findMany().stream().map(this::resultPostProcessor).collect(Collectors.toList());

    }

    private Payment resultPostProcessor(Payment payment) {
        return payment.put("relatedCustomer", payment.findRelatedOne(db, tabCustomer));
        //OR
//        payment.put("relatedCustomer",Select.oneByPK(db,tabCustomer,payment.getCustomerId()));
    }

}
