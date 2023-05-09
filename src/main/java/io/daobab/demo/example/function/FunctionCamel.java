package io.daobab.demo.example.function;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * Function Camel
 * ---------------------------------------------------------
 */
@Component
public class FunctionCamel extends ServiceBase<List<String>> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FunctionCamel.class.getName());
    }

    @Override
    public List<String> call() {
        var t = tabCountry;
        return db.select(camel(t.colCountry()))
                .whereBetween(t.colID(), 10, 20)
                .findMany();
    }


}
