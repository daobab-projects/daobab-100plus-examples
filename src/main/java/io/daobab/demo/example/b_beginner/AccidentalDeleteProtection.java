package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Accidental delete protection
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class AccidentalDeleteProtection extends ServiceBase<Integer> {


    @Override
    public Integer call() {
        return db.delete(tabActor).execute();
    }


}
