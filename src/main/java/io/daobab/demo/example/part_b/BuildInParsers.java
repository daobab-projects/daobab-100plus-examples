package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * ---------------------------------------------------------
 * BuildIn Parsers
 * ---------------------------------------------------------
 */
@Component
public class BuildInParsers extends ServiceBase<List<Film>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, BuildInParsers.class.getName());
    }

    @Override
    public List<Film> call() {
        var f = tabFilm;

        Long id = 500L;
        var amount = Float.parseFloat("10.02");

        return db.select(f)
                .where(and()
                        .less(f.colFilmId(), toInteger(id))
                        .equal(f.colSpecialFeatures(), "Deleted Scenes")
                        .greater(f.colReplacementCost(), toBigDecimal(amount))
                        .greater(f.colLength(), toInteger("5"))
                        .less(f.colLastUpdate(), LocalDate.parse("2009-12-10").atStartOfDay())
                )
                .orderDescBy(f.colDescription())
                .findMany();

    }


}
