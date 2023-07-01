package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.database.query.frozen.FrozenDataBaseQueryField;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to create a frozenQuery
 * ---------------------------------------------------------
 */
@Component
public class FrozenQueryNoParameters extends ServiceBase<List<String>> {

    private FrozenDataBaseQueryField<Customer, String> frozenQuery ;

    @PostConstruct
    public void init(){
        frozenQuery =
        db.select(tabCustomer.colFirstName())
                .whereLess(tabCustomer.colID(), 10).freezeQuery();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FrozenQueryNoParameters.class.getName());
    }

    @Override
    public List<String> call() {
        return frozenQuery.findMany();
    }


}
