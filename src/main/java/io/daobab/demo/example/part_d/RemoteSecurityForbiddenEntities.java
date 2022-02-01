package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Payment;
import org.springframework.boot.SpringApplication;
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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemoteSecurityForbiddenEntities.class.getName());
    }

    @Override
    public List<Payment> call() {
        var t = tabPayment;
        return remote.select(t)
                .whereLess(t.colID(), 10)
                .findMany();
    }


}
