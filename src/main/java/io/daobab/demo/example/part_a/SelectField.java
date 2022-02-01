package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to get single value of particular column
 * ---------------------------------------------------------
 */
@Component
public class SelectField extends ServiceBase<String> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectField.class.getName());
    }

    @Override
    public String call() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .whereEqual(c.colID(), 10)
                .findOne();
    }


}
