package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Payment;
import io.daobab.parser.ParserGeneral;
import org.springframework.boot.SpringApplication;
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
public class ResultPostProcessor extends ServiceBase<List<Payment>> implements ParserGeneral {

    private final BigDecimal _200 = new BigDecimal(200);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ResultPostProcessor.class.getName());
    }

    @Override
    public List<Payment> call() {
        return db.select(tabPayment)
                .whereEqual(tabPayment.colAmount(), toBigDecimal(100))
                .orderAscBy(tabPayment.colPaymentDate())
                .findMany()
                .stream()
                .map(this::myPostProcess)
                .collect(Collectors.toList());
    }

    private Payment myPostProcess(Payment payment) {
        return payment.put("amount_GT_200", payment.getAmount().compareTo(_200) > 0);
    }

}
