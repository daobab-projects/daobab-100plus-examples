package io.daobab.demo.example.function;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Function DayOfYear
 * ---------------------------------------------------------
 */
@Component
public class FunctionDayOfYear extends ServiceBase<Integer> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FunctionDayOfYear.class.getName());
    }

    @Override
    public Integer call() {
        return db.select(dayOfYear(tabCountry.colLastUpdate())).findOne();
    }


}
