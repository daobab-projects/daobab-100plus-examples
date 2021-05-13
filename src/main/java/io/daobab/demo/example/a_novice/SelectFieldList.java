package io.daobab.demo.example.a_novice;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get values of particular column
 * ---------------------------------------------------------
 */
@Component
public class SelectFieldList extends ServiceBase<List<String>> {

    @Override
    public List<String> call() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .whereLess(c.colID(), 10)
                .findMany();
    }


}
