package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.Lang;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Select Native Many Cells
 * ---------------------------------------------------------
 */
@Component
public class SelectNativeManyCells extends ServiceBase<List<Lang>> {


    @Override
    public List<Lang> call() {
        var t = tabLanguage;
        return db.nativeSelect("select name from language order by 1 asc",
                t.colName())
                .findMany();
    }


}
