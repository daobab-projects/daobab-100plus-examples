package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ---------------------------------------------------------
 * - How to insert entity by PK method.
 * ---------------------------------------------------------
 */
@Component
public class PrimaryKeyInsert extends ServiceBase<Category> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyInsert.class.getName());
    }

    @Override
    public Category call() {
        return new Category()
                .setLastUpdate(LocalDateTime.now())
                .setName("test")
                .insert(db);
    }


    public Category way02() {
        var category = new Category()
                .setLastUpdate(LocalDateTime.now())
                .setName("test");

        return db.insert(category).execute();
    }

}
