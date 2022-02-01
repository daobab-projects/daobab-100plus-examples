package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Inner Select
 * ---------------------------------------------------------
 * - How to use inner selects
 */
@Component
public class InnerSelect extends ServiceBase<FlatPlates> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, InnerSelect.class.getName());
    }

    @Override
    public FlatPlates call() {
        var rv = way01();
        rv.forEach(r -> log.info(r.toString()));
        return rv;
    }


    public FlatPlates way01() {

        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .whereIn(c.colAddressId(),
                        db.select(a.colAddressId()).whereEqual(a.colPostalCode(), "85505"))
                .findManyAsFlat();

    }


}
