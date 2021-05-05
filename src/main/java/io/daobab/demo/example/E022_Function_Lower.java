package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.lower;

/**
 * ---------------------------------------------------------
 * Function Lower
 * ---------------------------------------------------------
 * - How to use function Lower (and upper)
 */
@Component
public class E022_Function_Lower extends ServiceBase<List<String>> {

    @Override
    public List<String> call() {
        var t = tabCountry;
        return db.select(lower(t.colCountry()))
                .whereBetween(t.colID(), 10, 20)
                .findMany();
    }


}
