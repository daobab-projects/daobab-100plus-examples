package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.Lang;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to use Enums
 * ---------------------------------------------------------
 */
@Component
public class Enums extends ServiceBase<List<Lang>> {


    @Override
    public List<Lang> call() {
        var t = tabLanguage;
        return db.select(t.colName())
                .orderAscBy(t.colName())
                .findMany();
    }


}
