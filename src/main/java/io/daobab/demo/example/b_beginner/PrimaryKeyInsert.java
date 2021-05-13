package io.daobab.demo.example.b_beginner;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to insert entity by PK method.
 * ---------------------------------------------------------
 */
@Component
public class PrimaryKeyInsert extends ServiceBase<Category> {

    @Override
    public Category call() {
        return way01();
    }

    public Category way01() {
        return new Category()
                .setLastUpdate(toCurrentTimestamp())
                .setName("test")
                .insert(db);
    }


    public Category way02() {
        var category = new Category()
                .setLastUpdate(toCurrentTimestamp())
                .setName("test");

        return db.insert(category).execute();
    }

}
