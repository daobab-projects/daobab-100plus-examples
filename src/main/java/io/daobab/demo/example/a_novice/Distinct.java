package io.daobab.demo.example.a_novice;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to use distinct
 * ---------------------------------------------------------
 */
@Component
public class Distinct extends ServiceBase<List<String>> {

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