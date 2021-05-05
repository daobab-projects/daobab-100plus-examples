package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.count;

/**
 * ---------------------------------------------------------
 * Having
 * ---------------------------------------------------------
 * - How to use Having
 */
@Component
public class E054_Having extends ServiceBase<List<FlatPlate>> {

    @Override
    public List<FlatPlate> call() {
        var c = tabFilm;
        return db.select(c.colRating(), count(c.colID()).as("cnt"))
                .groupBy(c.colRating())
                .logQuery()
                .havingGreater("cnt", 200)
                .flat()
                .findMany();
    }


}
