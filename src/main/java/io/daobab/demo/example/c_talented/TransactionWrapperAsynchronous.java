package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Asynchronous Transaction wrapper
 * ---------------------------------------------------------
 * - How to wrap some DB operations into one transaction and don't wait for the execution end.
 */
@Component
public class TransactionWrapperAsynchronous extends ServiceBase<Void> {

    @SuppressWarnings("unchecked")
    @Override
    public Void call() {

        //Wrap all operation into single transaction
        db.wrapTransactionAsynch(transaction -> {
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
                    return null;
                }
        );
        return null;
    }

}
