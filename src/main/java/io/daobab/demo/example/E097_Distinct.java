package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Distinct
 * ---------------------------------------------------------
 * - How to use Distinct
 */
@Component
public class E097_Distinct extends ServiceBase<List<String>> {


    @Override
    public List<String> call() {
        var p = tabCustomer;

        return db.select(p.colFirstName())
                .distinct()
                .orderAscBy(p.colFirstName())
                .limitBy(15)
                .findMany();
    }


}
