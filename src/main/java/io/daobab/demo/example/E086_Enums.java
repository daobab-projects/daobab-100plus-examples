package io.daobab.demo.example;

import io.daobab.demo.dao.Lang;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Enums
 * ---------------------------------------------------------
 * - How to use Enums
 */
@Component
public class E086_Enums extends ServiceBase<List<Lang>> {


    @Override
    public List<Lang> call() {
        var t = tabLanguage;
        return db.select(t.colName())
                .orderAscBy(t.colName())
                .findMany();
    }


}
