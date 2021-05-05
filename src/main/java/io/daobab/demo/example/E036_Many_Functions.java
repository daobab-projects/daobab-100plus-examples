package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
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
public class E036_Many_Functions extends ServiceBase<FlatPlate> {

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
