package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * Join by different columns
 * ---------------------------------------------------------
 * - How to use joins linking different columns
 */
@Component
public class JoinViaDifferentColumns extends ServiceBase<List<FlatPlate>> {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, JoinViaDifferentColumns.class.getName());
    }


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
