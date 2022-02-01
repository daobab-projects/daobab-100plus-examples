package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Group By
 * ---------------------------------------------------------
 */
@Component
public class GroupBy extends ServiceBase<FlatPlates> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, GroupBy.class.getName());
    }

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
