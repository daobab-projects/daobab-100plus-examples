package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * OCC
 * ---------------------------------------------------------
 * - How to use Optimistic Concurrency Control
 */
@Component
public class OptimisticConcurrencyControlForPrimaryKey extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, OptimisticConcurrencyControlForPrimaryKey.class.getName());
    }

    @Override
    public Void call() {
        var f = tabStaff;
        var staff = db.findOneByPk(f, 1);
        staff.update(db, f.colEmail());
        return null;
    }


}
