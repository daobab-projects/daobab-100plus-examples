package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * Join by different columns
 * ---------------------------------------------------------
 * - How to use joins linking different columns
 */
@Component
public class E029_Join_Via_Different_Columns extends ServiceBase<List<FlatPlate>> {

    @Override
    public List<FlatPlate> call() {
        var rv = way01();
        rv.forEach(r -> log.info(r.toString()));
        return rv;
    }


    public List<FlatPlate> way01() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                //specify tables to join from left and right table
                .join(a, joinOn(a.colAddressId(), c.colAddressId()))
                .flat()
                .findMany();
    }


}
