package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Category;
import io.daobab.transaction.Propagation;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ---------------------------------------------------------
 * Transaction wrapper
 * ---------------------------------------------------------
 * - How to wrap some DB operations into one transaction
 */
@Component
public class TransactionWrapperVoid extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, TransactionWrapperVoid.class.getName());
    }


    @Override
    public Void call() {


        var cat = new Category()
                .setLastUpdate(LocalDateTime.now())
                .setName("test");

        var anotherCat = db.select(tabCategory).whereEqual(tabCategory.colID(), 1).findOne();
        anotherCat.setName("anotherName");

        db.wrapTransaction(t -> {
            t.insert(cat).execute();
            t.update(anotherCat).execute(Propagation.REQUIRED_NEW);
            return null;
        });


        //Wrap all operation into single transaction
        db.wrapTransaction(transaction -> {
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
