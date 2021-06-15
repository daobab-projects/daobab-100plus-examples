package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Combined Functions
 * ---------------------------------------------------------
 */
@Component
public class CombinedFunctions extends ServiceBase<Integer> implements FunctionWhispererH2 {

    @Override
    public Integer call() {
        return db.select(max(length(tabFilm.colDescription())))
                .whereEqual(tabFilm.colID(), 10)
                .findOne();
    }


}
