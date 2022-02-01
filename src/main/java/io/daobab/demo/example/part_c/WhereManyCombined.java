package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Where AND and OR combined
 * ---------------------------------------------------------
 * - How to safety combine different Where clauses
 */
@Component
public class WhereManyCombined extends ServiceBase<Entities<Customer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereManyCombined.class.getName());
    }


    @Override
    public Entities<Customer> call() {
        var t = tabCustomer;
        return db.select(t)
                .where(or()
                        .or(and()
                                .greaterOrEqual(t.colID(), 5)
                                .less(t.colID(), 10))
                        .or(and()
                                .greaterOrEqual(t.colID(), 15)
                                .less(t.colID(), 20))
                )
                .findMany();
    }


}
