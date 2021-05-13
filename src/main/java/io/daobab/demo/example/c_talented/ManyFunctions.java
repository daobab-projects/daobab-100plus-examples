package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.*;

/**
 * ---------------------------------------------------------
 * Many Function
 * ---------------------------------------------------------
 * - How to use many sql functions
 */
@Component
public class ManyFunctions extends ServiceBase<FlatPlate> {

    @Override
    public FlatPlate call() {
        var f = tabFilm;
        return db.select(
                sum(f.colLength()),
                avg(f.colLength()),
                min(f.colLength()),
                max(f.colLength()),
                count(f.colLength())
        )
                .flat()
                .findOne();
    }


}
