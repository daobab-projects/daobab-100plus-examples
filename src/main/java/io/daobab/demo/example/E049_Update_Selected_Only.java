package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.query.base.QueryWhisperer;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * PK - Update selected only
 * ---------------------------------------------------------
 * - How to use PK method to update just selected columns
 */
@Component
public class E049_Update_Selected_Only extends ServiceBase<Void> implements QueryWhisperer {

    @Override
    public Void call() {
        way01();
        return null;
    }

    public void way01() {
        var category = db.findOneByPk(tabCategory, 1);
        category.setLastUpdate(toCurrentTimestamp());
        //update single column only
        category.update(db, tabCategory.colLastUpdate());
    }


    public void way02() {
        db.update(tabCategory.colLastUpdate(), toCurrentTimestamp())
                .whereEqual(tabCategory.colCategoryId(), 1)
                .execute();
    }


}
