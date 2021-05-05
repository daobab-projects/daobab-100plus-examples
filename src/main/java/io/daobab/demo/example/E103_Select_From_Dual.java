package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.count;


/**
 * ---------------------------------------------------------
 * Select from dual
 * ---------------------------------------------------------
 * - Plate contains two counts. There is no table to select from.
 * For those cases, SQL provides a DUAL - dummy table, which is used
 * in the background.
 */
@Component
public class E103_Select_From_Dual extends ServiceBase<Plate> {


    @Override
    public Plate call() {
        return db.select(
                db.select(count(tabFilm)).as("cntFilm"),
                db.select(count(tabCustomer)).as("cntCustomer"))
                .findOne();
// uncomment to read
//              .forEach(p->log.info(p.getValue("cntFilm")+" -- "+p.getValue("cntCustomer")));
    }


}
