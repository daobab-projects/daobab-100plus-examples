package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Select One Cell
 * ---------------------------------------------------------
 * - How to get values from particular column
 */
@Component
public class E015_Column_List_Values extends ServiceBase<List<String>> {

    @Override
    public List<String> call() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .whereLess(c.colID(), 10)
                .findMany();
    }


}
