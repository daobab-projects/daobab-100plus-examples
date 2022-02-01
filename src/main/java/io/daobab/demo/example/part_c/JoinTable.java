package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Table
 * ---------------------------------------------------------
 * - How to join tables by the same column (PK,FK)
 */
@Component
public class JoinTable extends ServiceBase<FlatPlates> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, JoinTable.class.getName());
    }

    @Override
    public FlatPlates call() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .join(a, c.colAddressId())
                .findManyAsFlat();
    }


}
