package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Group By
 * ---------------------------------------------------------
 */
@Component
public class GroupBy extends ServiceBase<FlatPlates> implements FunctionWhispererH2 {

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
