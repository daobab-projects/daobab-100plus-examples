package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Many Function
 * ---------------------------------------------------------
 * - How to use many sql functions
 */
@Component
public class ManyFunctions extends ServiceBase<FlatPlate> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ManyFunctions.class.getName());
    }

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
