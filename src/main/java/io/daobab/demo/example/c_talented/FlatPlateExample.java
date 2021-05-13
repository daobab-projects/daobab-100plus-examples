package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select FlatPlate from Many Tables
 * ---------------------------------------------------------
 * - How to get specific columns from many tables, for one rows
 * but by FlatPlate
 * ---------------------------------------------------------
 * - FlatPlate can be used when all columns selected have unique name
 * - Plate is able to handle many columns with the same name,
 * belonging to different Entities
 */
@Component
public class FlatPlateExample extends ServiceBase<FlatPlate> {


    @Override
    public FlatPlate call() {
        var t = tabCustomer;
        var a = tabAddress;
        return db.select(t.colFirstName(), t.colLastName(), a.colAddress())
                .join(a, t.colAddressId())
                .where(and()
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON"))
                .flat()  //<-enabling flat
                .findOne();

    }


}
