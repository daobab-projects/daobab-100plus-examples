package io.daobab.demo.example;

import io.daobab.demo.dao.Lang;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Select Native Many Cells
 * ---------------------------------------------------------
 * - How to use Select Native Many Cells
 */
@Component
public class E087_Select_Native_Many_Cells extends ServiceBase<List<Lang>> {


    @Override
    public List<Lang> call() {
        var t = tabLanguage;
        return db.nativeSelect("select name from language order by 1 asc",
                t.colName())
                .findMany();
    }


}
