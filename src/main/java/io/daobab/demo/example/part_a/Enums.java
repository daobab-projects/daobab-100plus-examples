package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.Lang;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to use Enums
 * ---------------------------------------------------------
 */
@Component
public class Enums extends ServiceBase<List<Lang>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Enums.class.getName());
    }


    @Override
    public List<Lang> call() {
        var t = tabLanguage;
        return db.select(t.colName())
                .orderAscBy(t.colName())
                .findMany();
    }


}
