package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.parser.ParserDate;
import io.daobab.parser.ParserGeneral;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

import static java.lang.String.format;

/**
 * ---------------------------------------------------------
 * - big query in use
 * ---------------------------------------------------------
 */
@Component
public class BigQuery extends ServiceBase<List<String>> implements ParserGeneral {

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
                .map(x -> format("Customer: %s,%s living in %s,%s rent on %s a movie: %s has paid for it: %s and was served by %s %s",
                        x.getValue(c.colFirstName()) ,
                        x.getValue(c.colLastName()) ,
                        x.getValue(city.colCity()) ,
                        x.getValue(country.colCountry()) ,
                        ParserDate.toString(x.getValue(p.colPaymentDate()), "EEEE, dd MMMM yyyy (HH:mm)", Locale.ENGLISH),
                        x.getValue(f.colTitle()) ,
                        x.getValue(p.colAmount()) ,
                        x.getValue(s.colFirstName()) ,
                        x.getValue(s.colLastName())
                        ))
                .findMany();


    }


}
