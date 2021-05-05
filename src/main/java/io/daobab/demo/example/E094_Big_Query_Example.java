package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

/**
 * ---------------------------------------------------------
 * Big Query Example
 * ---------------------------------------------------------
 * - big query in use
 */
@Component
public class E094_Big_Query_Example extends ServiceBase<List<String>> {


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
                .map(x -> {
                    var sb = new StringBuffer()
                            .append("Customer:")
                            .append(x.getValue(c.colFirstName()))
                            .append(",")
                            .append(x.getValue(c.colLastName()))
                            .append(" living in ")
                            .append(x.getValue(city.colCity()))
                            .append(",")
                            .append(x.getValue(country.colCountry()))
                            .append(" rent on ")
                            .append(toSting(x.getValue(p.colPaymentDate()), "EEEE, dd MMMM yyyy (HH:mm)", Locale.ENGLISH))
                            .append(" a movie: ")
                            .append(x.getValue(f.colTitle()))
                            .append(" has paid for it: ")
                            .append(x.getValue(p.colAmount()))
                            .append(" and was served by ")
                            .append(x.getValue(s.colFirstName()))
                            .append(" ")
                            .append(x.getValue(s.colLastName())

                            );
                    return sb.toString();
                })
                .findMany();


    }


}
