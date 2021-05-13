package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.Function.lower;

/**
 * ---------------------------------------------------------
 * Function Lower
 * ---------------------------------------------------------
 */
@Component
public class FunctionLower extends ServiceBase<List<String>> {

    @Override
    public List<String> call() {
        var t = tabCountry;
        return db.select(lower(t.colCountry()))
                .whereBetween(t.colID(), 10, 20)
                .findMany();
    }


}
