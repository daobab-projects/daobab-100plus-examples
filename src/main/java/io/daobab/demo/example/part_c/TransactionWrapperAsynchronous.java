package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ---------------------------------------------------------
 * Asynchronous Transaction wrapper
 * ---------------------------------------------------------
 * - How to wrap some DB operations into one transaction and don't wait for the execution end.
 */
@Component
public class TransactionWrapperAsynchronous extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, TransactionWrapperAsynchronous.class.getName());
    }


    @SuppressWarnings("unchecked")
    @Override
    public Void call() {

        //Wrap all operation into single transaction
        db.wrapTransactionAsynch(transaction -> {
                    //Insert entity
                    var category = new Category()
                            .setLastUpdate(LocalDateTime.now())
                            .setName("test")
                            .insert(transaction);

                    //Update entity
            category.setLastUpdate(LocalDateTime.now())
                            .update(transaction, tabCategory.colLastUpdate());

                    //Delete entity
                    category.delete(transaction);
                    return null;
                }
        );
        return null;
    }

}
