package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to delete entity by PK method.
 * ---------------------------------------------------------
 */
@Component
public class PrimaryKeyDelete extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PrimaryKeyDelete.class.getName());
    }

    @Override
    public Void call() {
        var category = db.findOneByPk(tabCategory, 11111);
        if (category != null) {
            category.delete(db);
        }
        return null;
    }


}
