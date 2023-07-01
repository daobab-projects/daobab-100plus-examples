package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

/**
 * ---------------------------------------------------------
 * - big query in use
 * ---------------------------------------------------------
 */
@Component
public class BigQuery extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, BigQuery.class.getName());
    }

    @Override
    public List<String> call() {
        var c = tabCustomer;
        var city = tabCity;
        var country = tabCountry;
        var r = tabRental;
        var p = tabPayment;
        var a = tabAddress;
        var s = tabStaff;
        var f = tabFilm;
        var i = tabInventory;


        return db.select(
                        c.colFirstName(), c.colLastName(), f.colTitle(), city.colCity(), p.colPaymentDate(), p.colAmount(),
                        country.colCountry(), s.colFirstName(), s.colLastName())
                .join(r, c.colCustomerId())
                .join(i, r.colInventoryId())
                .join(p, c.colCustomerId(), r.colStaffId())
                .join(s, r.colStaffId())
                .join(a, c.colAddressId())
                .join(city, a.colCityId())
                .join(country, city.colCountryId())
                .join(f, i.colFilmId())
                .orderDescBy(p.colPaymentDate())
                .limitBy(10)
                .whereEqual(c.colID(), 1)
                .map(x -> "Customer:" +
                        x.getValue(c.colFirstName()) +
                        "," +
                        x.getValue(c.colLastName()) +
                        " living in " +
                        x.getValue(city.colCity()) +
                        "," +
                        x.getValue(country.colCountry()) +
                        " rent on " +
                        toSting(x.getValue(p.colPaymentDate()), "EEEE, dd MMMM yyyy (HH:mm)", Locale.ENGLISH) +
                        " a movie: " +
                        x.getValue(f.colTitle()) +
                        " has paid for it: " +
                        x.getValue(p.colAmount()) +
                        " and was served by " +
                        x.getValue(s.colFirstName()) +
                        " " +
                        x.getValue(s.colLastName())
                )
                .findMany();


    }


}
