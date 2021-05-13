package io.daobab.demo.example.d_proficient;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.base.ServiceBase;
import io.daobab.transaction.Propagation;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Transaction Propagation
 * ---------------------------------------------------------
 * - How to propagate transactions
 */
@Component
public class TransactionPropagation extends ServiceBase<Void> {

    @Override
    public Void call() {

        //Open transaction manually
        var transaction = db.beginTransaction();

        try {
            //Insert entity
            var category = new Category()
                    .setLastUpdate(toCurrentTimestamp())
                    .setName("test")
                    .insert(transaction, Propagation.REQUIRED_NEW);

            //Update entity
            db.update(tabCategory.colLastUpdate(), toCurrentTimestamp())
                    .whereEqual(tabCategory.colCategoryId(), 1)
                    .execute(Propagation.SUPPORTS);

            //Delete entity
            category.delete(transaction, Propagation.MANDATORY);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return null;

    }

}
