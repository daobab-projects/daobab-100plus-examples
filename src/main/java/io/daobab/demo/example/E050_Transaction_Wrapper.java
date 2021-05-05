package io.daobab.demo.example;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Transaction wrapper
 * ---------------------------------------------------------
 * - How to wrap some DB operations into one transaction
 */
@Component
public class E050_Transaction_Wrapper extends ServiceBase<Void> {

    @Override
    public Void call() {

        //Wrap all operation into single transaction
        db.wrapTransaction(transaction -> {
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
