package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Many Tables
 * ---------------------------------------------------------
 * - How to join multiple tables by the same column (PK,FK)
 */
@Component
public class JoinManyTables extends ServiceBase<FlatPlates> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, JoinManyTables.class.getName());
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
