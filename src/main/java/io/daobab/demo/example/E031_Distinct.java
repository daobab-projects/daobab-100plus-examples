package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * Distinct
 * ---------------------------------------------------------
 * - How to use distinct
 */
@Component
public class E031_Distinct extends ServiceBase<List<String>> {

    @Override
    public List<String> call() {
        var rv = way01();
        rv.forEach(r -> log.info(r));
        return rv;
    }


    public List<String> way01() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .distinct()
                .orderAscBy(c.colFirstName())
                .findMany();
    }


}
