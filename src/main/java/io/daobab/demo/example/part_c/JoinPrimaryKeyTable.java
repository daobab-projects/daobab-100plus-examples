package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.FlatPlates;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Join Table by PrimaryKey
 * ---------------------------------------------------------
 * - How to join table by their PK
 */
@Component
public class JoinPrimaryKeyTable extends ServiceBase<FlatPlates> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, JoinPrimaryKeyTable.class.getName());
    }

    @Override
    public FlatPlates call() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .joinPk(a)
                .limitBy(10)
                .findManyAsFlat();
    }


}
