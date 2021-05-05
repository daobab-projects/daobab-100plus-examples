package io.daobab.demo.example;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Manual Transaction
 * ---------------------------------------------------------
 * - How to start, commit and rollback DB Operations having manual control on it.
 */
@Component
public class E052b_Transaction_Manual extends ServiceBase<Void> {

    @SuppressWarnings({"unchecked","Duplicates"})
    @Override
    public Void call() {

        //Open transaction manually
        var transaction = db.beginTransaction();

        try {
            //Insert entity
            var category = new Category()
                    .setLastUpdate(toCurrentTimestamp())
                    .setName("test")
                    .insert(transaction);

            //Update entity
            category.setLastUpdate(toCurrentTimestamp())
                    .update(transaction, tabCategory.colLastUpdate());

            //Delete entity
            category.delete(transaction);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return null;
    }

}
