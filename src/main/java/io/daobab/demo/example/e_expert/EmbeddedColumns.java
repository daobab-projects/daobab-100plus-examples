package io.daobab.demo.example.e_expert;

import io.daobab.demo.dao.table.enhanced.CountryCity;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Embedded Columns
 * ---------------------------------------------------------
 * - How to use Embedded Columns (see into CounterCity entity)
 */
@Component
public class EmbeddedColumns extends ServiceBase<Entities<CountryCity>> {


    @Override
    public Entities<CountryCity> call() {
        var c = tabCountryCity;
        return db.select(c)
                .whereLess(c.colID(), 5)
                .findMany();
    }


}
