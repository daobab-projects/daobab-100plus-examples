package io.daobab.demo.example.e_expert;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * OCC
 * ---------------------------------------------------------
 * - How to use Optimistic Concurrency Control
 */
@Component
public class OptimisticConcurrencyControlForPrimaryKey extends ServiceBase<Void> {


    @Override
    public Void call() {
        var f = tabStaff;
        var staff = db.findOneByPk(f, 1);
        staff.update(db, f.colEmail());
        return null;
    }


}
