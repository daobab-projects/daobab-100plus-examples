package io.daobab.demo.example;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Remote Security Forbidden Entities
 * ---------------------------------------------------------
 * - How to prevent from select forbidden entities
 */
@Component
public class E084_Remote_Security_Forbidden_Entities extends ServiceBase<List<Payment>> {


    @Override
    public List<Payment> call() {
        var t = tabPayment;
        return remote.select(t)
                .whereLess(t.colID(), 10)
                .findMany();
    }


}
