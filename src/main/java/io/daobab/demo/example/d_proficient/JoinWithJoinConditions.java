package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Join Table With Join Conditions
 * ---------------------------------------------------------
 * - How to join tables with where conditions attached
 */
@Component
public class JoinWithJoinConditions extends ServiceBase<List<FlatPlate>> {

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
                .flat()
                .findMany();
    }


}
