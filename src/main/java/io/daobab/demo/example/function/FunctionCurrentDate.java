package io.daobab.demo.example.function;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


/**
 * ---------------------------------------------------------
 * Function CurrentDate
 * ---------------------------------------------------------
 */
@Component
public class FunctionCurrentDate extends ServiceBase<Timestamp> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FunctionCurrentDate.class.getName());
    }

    @Override
    public Timestamp call() {
        return db.select(currentDate()).findOne();
    }


}
