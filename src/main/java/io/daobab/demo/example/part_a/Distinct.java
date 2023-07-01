package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to use distinct
 * ---------------------------------------------------------
 */
@Component
public class Distinct extends ServiceBase<List<String>> implements FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Distinct.class.getName());
    }

    @Override
    public List<String> call() {
        var p = tabCustomer;

        return db.select(distinct(p.colFirstName()))
                .orderAscBy(p.colFirstName())
                .limitBy(15)
                .findMany();
    }


}
