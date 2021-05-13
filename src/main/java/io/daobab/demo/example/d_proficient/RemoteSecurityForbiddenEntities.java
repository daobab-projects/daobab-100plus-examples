package io.daobab.demo.example.d_proficient;

import io.daobab.demo.dao.table.Payment;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Remote Security Forbidden Entities
 * ---------------------------------------------------------
 * - How to prevent from select forbidden entities
 */
@Component
public class RemoteSecurityForbiddenEntities extends ServiceBase<List<Payment>> {


    @Override
    public List<Payment> call() {
        var t = tabPayment;
        return remote.select(t)
                .whereLess(t.colID(), 10)
                .findMany();
    }


}
