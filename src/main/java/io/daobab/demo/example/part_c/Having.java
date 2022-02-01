package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Having
 * ---------------------------------------------------------
 */
@Component
public class Having extends ServiceBase<List<FlatPlate>> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Having.class.getName());
    }

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
