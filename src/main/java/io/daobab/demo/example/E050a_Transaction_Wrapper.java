package io.daobab.demo.example;

import io.daobab.demo.dao.table.Category;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.transaction.Propagation;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Transaction wrapper
 * ---------------------------------------------------------
 * - How to wrap some DB operations into one transaction
 */
@Component
public class E050a_Transaction_Wrapper extends ServiceBase<Void> {

    @Override
    public Void call() {



        var cat=new Category()
                .setLastUpdate(toCurrentTimestamp())
                .setName("test");

        var anotherCat=db.select(tabCategory).whereEqual(tabCategory.colID(),1).findOne().clone();
        anotherCat.setName("anotherName");

        db.wrapTransaction( t->{
            t.insert(cat).execute();
            t.update(anotherCat).execute(Propagation.REQUIRED_NEW);
            return null;
        });






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
