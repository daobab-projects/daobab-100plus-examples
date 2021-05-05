package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * OCC
 * ---------------------------------------------------------
 * - How to use Optimistic Concurrency Control
 */
@Component
public class E093_Optimistic_Concurrency_Control_For_PrimaryKey extends ServiceBase<Void> {


    @Override
    public Void call() {
        var f = tabStaff;
        var staff = db.findOneByPk(f, 1);
        staff.update(db, f.colEmail());
        return null;
    }


}
