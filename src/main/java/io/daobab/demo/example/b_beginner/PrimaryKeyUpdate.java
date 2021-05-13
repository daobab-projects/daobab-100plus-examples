package io.daobab.demo.example.b_beginner;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to update entity by PK method.
 * ---------------------------------------------------------
 */
@Component
public class PrimaryKeyUpdate extends ServiceBase<Category> {

    @Override
    public Category call() {
        return way01();
    }

    public Category way01() {
        Category category = db.findOneByPk(tabCategory, 1);
        category.setLastUpdate(toCurrentTimestamp());
        category.update(db);
        return category;
    }


    public Category way02() {
        var category = new Category()
                .setLastUpdate(toCurrentTimestamp());

        db.update(category).execute();

        return category;
    }

}
