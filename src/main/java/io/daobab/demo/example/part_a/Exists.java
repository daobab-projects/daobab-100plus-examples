package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to check if the record exists
 * ---------------------------------------------------------
 */
@Component
public class Exists extends ServiceBase<Boolean> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Exists.class.getName());
    }

    //Only one record is retrieved from the database
    @Override
    public Boolean call() {
        return db.select(tabCustomer)
                .whereEqual(tabCustomer.colID(), 10)
                .exists();
    }


}
