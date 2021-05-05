package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK - Delete
 * ---------------------------------------------------------
 * - How to delete entity by PK method.
 */
@Component
public class E048_PrimaryKey_Delete extends ServiceBase<Void> {

    @Override
    public Void call() {
        way01();
        return null;
    }

    public void way01() {
        var category = db.findOneByPk(tabCategory, 11111);
        if (category != null) {
            category.delete(db);
        }
    }


}
