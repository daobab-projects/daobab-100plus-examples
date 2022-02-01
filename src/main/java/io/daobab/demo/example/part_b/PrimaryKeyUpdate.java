package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to update entity by PK method.
 * ---------------------------------------------------------
 */
@Component
public class PrimaryKeyUpdate extends ServiceBase<Category> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyUpdate.class.getName());
    }

    @Override
    public Category call() {
        return way01();
    }

    public Category way01() {
        return db.findOneByPk(tabCategory, 1)
                .setLastUpdate(toCurrentTimestamp())
                .update(db);
    }


    public Category way02() {
        var category = new Category()
                .setLastUpdate(toCurrentTimestamp());

        db.update(category).execute();

        return category;
    }

}
