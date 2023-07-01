package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Order Join Many Tables
 * ---------------------------------------------------------
 * - How to order many tables results
 */
@Component
public class OrderJoinManyTables extends ServiceBase<List<FlatPlate>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, OrderJoinManyTables.class.getName());
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
        var city = tabCity;
        var country = tabCountry;
        return db.select(
                        c.colFirstName(), c.colLastName(), a.colPhone(), city.colCity(), country.colCountry())
                .join(a, c.colAddressId(), and().equal(c.colActive(), true))
                .join(city, a.colCityId(), and().like(city.colCity(), "%a%"))
                .join(country, city.colCountryId(), and().in(country.colCountry(), "United States", "Russian Federation"))
                .orderBy(asc(country.colCountry()).desc(c.colFirstName()))
                .findManyAsFlat();
    }

    public List<FlatPlate> way02() {
        var c = tabCustomer;
        var a = tabAddress;
        var city = tabCity;
        var country = tabCountry;
        return db.select(
                        c.colFirstName(), c.colLastName(), a.colPhone(), city.colCity(), country.colCountry())
                .join(a, c.colAddressId())
                .join(city, a.colCityId())
                .join(country, city.colCountryId())
                .where(and()
                        .equal(c.colActive(), true)
                        .like(city.colCity(), "%a%")
                        .in(country.colCountry(), "United States", "Russian Federation")
                )
                .orderBy(asc(country.colCountry()).desc(c.colFirstName()))
                .findManyAsFlat();
    }


}
