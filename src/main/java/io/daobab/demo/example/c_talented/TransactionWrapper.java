package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Transaction wrapper
 * ---------------------------------------------------------
 * - How to wrap some DB operations into one transaction
 */
@Component
public class TransactionWrapper extends ServiceBase<Void> {

    @Override
    public Void call() {

        //Wrap all operation into single transaction
        var deletedRecords=db.wrapTransaction(transaction -> {
                    //Insert entity
                    var category = new Category()
                            .setLastUpdate(toCurrentTimestamp())
                            .setName("test")
                            .insert(transaction);

                    //Update entity
                    category.setLastUpdate(toCurrentTimestamp())
                            .update(transaction, tabCategory.colLastUpdate());

                    //Delete entity
                    return category.delete(transaction);
                }
        );

        log.info("deleted records:"+deletedRecords);

        return null;
    }

}
