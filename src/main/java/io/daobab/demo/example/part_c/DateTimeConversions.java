package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;

/**
 * ---------------------------------------------------------
 * DateTime Conversion
 * ---------------------------------------------------------
 * - How to use time parser
 */
@Component
public class DateTimeConversions extends ServiceBase<List<Film>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, DateTimeConversions.class.getName());
    }

    @Override
    public List<Film> call() {
        var t = tabFilm;
        return db.select(t)
                .whereLess(t.colID(), 5)
                .map(e -> e.setLastUpdate(e.getLastUpdate().atZone(ZoneId.of("US/Alaska ")).toLocalDateTime()))
                .findMany();


    }


}
