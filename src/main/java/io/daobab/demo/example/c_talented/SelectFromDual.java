package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Plate;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Select from dual
 * ---------------------------------------------------------
 * - Plate contains two counts. There is no table to select from.
 * For those cases, SQL provides a DUAL - dummy table, which is used
 * in the background.
 */
@Component
public class SelectFromDual extends ServiceBase<Plate> implements FunctionWhispererH2 {


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
