package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Manual Transaction
 * ---------------------------------------------------------
 * - How to start, commit and rollback DB Operations having manual control on it.
 */
@Component
public class TransactionManual extends ServiceBase<Void> {

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
