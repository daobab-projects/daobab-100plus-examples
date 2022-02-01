package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Manual Transaction
 * ---------------------------------------------------------
 * - How to start, commit and rollback DB Operations having manual control on it.
 */
@Component
public class TransactionManual extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, TransactionManual.class.getName());
    }


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
