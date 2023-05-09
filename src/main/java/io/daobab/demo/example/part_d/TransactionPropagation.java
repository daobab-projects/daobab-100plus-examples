package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Category;
import io.daobab.transaction.Propagation;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ---------------------------------------------------------
 * Transaction Propagation
 * ---------------------------------------------------------
 * - How to propagate transactions
 */
@Component
public class TransactionPropagation extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, TransactionPropagation.class.getName());
    }

    @Override
    public Void call() {

        //Open transaction manually
        var transaction = db.beginTransaction();

        try {
            //Insert entity
            var category = new Category()
                    .setLastUpdate(LocalDateTime.now())
                    .setName("test")
                    .insert(transaction, Propagation.REQUIRED_NEW);

            //Update entity
            db.update(tabCategory.colLastUpdate(), LocalDateTime.now())
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
