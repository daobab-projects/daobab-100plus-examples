package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.query.base.QueryWhisperer;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ---------------------------------------------------------
 * PK - Update selected only
 * ---------------------------------------------------------
 * - How to use PK method to update just selected columns
 */
@Component
public class UpdateSelectedOnly extends ServiceBase<Void> implements QueryWhisperer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, UpdateSelectedOnly.class.getName());
    }


    @Override
    public Void call() {
        way01();
        return null;
    }

    public void way01() {
        var category = db.findOneByPk(tabCategory, 1);
        category.setLastUpdate(LocalDateTime.now());
        //update single column only
        category.update(db, tabCategory.colLastUpdate());
    }


    public void way02() {
        db.update(tabCategory.colLastUpdate(), LocalDateTime.now())
                .whereEqual(tabCategory.colCategoryId(), 1)
                .execute();
    }


}
