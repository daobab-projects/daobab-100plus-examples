package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Accidental delete protection
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class AccidentalDeleteProtection extends ServiceBase<Integer> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, AccidentalDeleteProtection.class.getName());
    }

    @Override
    public Integer call() {
        return db.delete(tabActor).execute();
    }


}
