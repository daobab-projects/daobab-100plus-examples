package io.daobab.demo.example.function;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * Function Lower
 * ---------------------------------------------------------
 */
@Component
public class FunctionLower extends ServiceBase<List<String>> implements FunctionWhispererH2 {

    @Override
    public List<String> call() {
        var t = tabCountry;
        return db.select(lower(t.colCountry()))
                .whereBetween(t.colID(), 10, 20)
                .findMany();
    }


}
