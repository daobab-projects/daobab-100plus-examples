package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.enhanced.CountryCity;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Embedded Columns
 * ---------------------------------------------------------
 * - How to use Embedded Columns (see into CounterCity entity)
 */
@Component
public class EmbeddedColumns extends ServiceBase<Entities<CountryCity>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, EmbeddedColumns.class.getName());
    }

    @Override
    public Entities<CountryCity> call() {
        var c = tabCountryCity;
        return db.select(c)
                .whereLess(c.colID(), 5)
                .findMany();
    }


}
