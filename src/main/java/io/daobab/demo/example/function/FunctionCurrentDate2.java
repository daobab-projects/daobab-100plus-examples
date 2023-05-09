package io.daobab.demo.example.function;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Function CurrentDate2
 * ---------------------------------------------------------
 */
@Component
public class FunctionCurrentDate2 extends ServiceBase<String> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FunctionCurrentDate2.class.getName());
    }

    @Override
    public String call() {
        return "";//db.select(substring("The time now is: ",currentDate().cast(String.class))).findOne();
    }


}
