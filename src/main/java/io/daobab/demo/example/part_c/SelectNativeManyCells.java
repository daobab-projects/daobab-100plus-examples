package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.Lang;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Select Native Many Cells
 * ---------------------------------------------------------
 */
@Component
public class SelectNativeManyCells extends ServiceBase<List<Lang>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectNativeManyCells.class.getName());
    }

    @Override
    public List<Lang> call() {
        var t = tabLanguage;
        return db.nativeSelect("select name from language order by 1 asc",
                t.colName())
                .findMany();
    }


}
