package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get values of particular column
 * ---------------------------------------------------------
 */
@Component
public class SelectFieldList extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectFieldList.class.getName());
    }

    @Override
    public List<String> call() {
        var c = tabCustomer;
        return db.select(c.colFirstName())
                .whereLess(c.colID(), 10)
                .findMany();
    }


}
