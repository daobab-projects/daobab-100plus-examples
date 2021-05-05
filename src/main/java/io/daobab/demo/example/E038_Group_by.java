package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.count;

/**
 * ---------------------------------------------------------
 * Group By
 * ---------------------------------------------------------
 * - How to use Group By
 */
@Component
public class E038_Group_by extends ServiceBase<FlatPlates> {

    @Override
    public FlatPlates call() {
        var c = tabFilm;
        return db.select(c.colRating(), count(c.colID()).as("count_groupBy"))
                .groupBy(c.colRating())
                .findManyAsFlat();
    }

    public FlatPlates call2() {

        var c = tabFilm;
        db.select(c.colRating(), count(c.colID()).as("count_groupBy"))
                .groupBy(c.colRating())
                .havingGreater(c.colLength(), 90)
                .findMany();


        return null;
    }


}
