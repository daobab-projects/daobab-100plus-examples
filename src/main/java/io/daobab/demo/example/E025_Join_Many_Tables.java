package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Many Tables
 * ---------------------------------------------------------
 * - How to join multiple tables by the same column (PK,FK)
 */
@Component
public class E025_Join_Many_Tables extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var rv = way01();
        rv.forEach(r -> log.info(r.toString()));
        return rv;
    }


    public FlatPlates way01() {
        var c = tabCustomer;
        var a = tabAddress;
        var city = tabCity;
        var country = tabCountry;
        return db.select(
                c.colFirstName(), c.colLastName(), a.colPhone(), city.colCity(), country.colCountry())
                .join(a, c.colAddressId())
                .join(city, a.colCityId())
                .join(country, city.colCountryId())
                .findManyAsFlat();
    }


}
