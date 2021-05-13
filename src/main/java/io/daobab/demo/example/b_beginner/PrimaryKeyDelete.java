package io.daobab.demo.example.b_beginner;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to delete entity by PK method.
 * ---------------------------------------------------------
 */
@Component
public class PrimaryKeyDelete extends ServiceBase<Void> {

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
