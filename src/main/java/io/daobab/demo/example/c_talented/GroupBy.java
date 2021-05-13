package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.stereotype.Component;

import static io.daobab.statement.Function.count;

/**
 * ---------------------------------------------------------
 * Group By
 * ---------------------------------------------------------
 */
@Component
public class GroupBy extends ServiceBase<FlatPlates> {

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
