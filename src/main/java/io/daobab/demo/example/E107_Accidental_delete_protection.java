package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Accidental delete protection
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class E107_Accidental_delete_protection extends ServiceBase<Integer> {


    @Override
    public Integer call() {
        return db.delete(tabActor).execute();
    }


}
