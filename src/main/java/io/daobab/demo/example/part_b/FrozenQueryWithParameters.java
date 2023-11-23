package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.database.query.frozen.FrozenDataBaseQueryField;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static io.daobab.target.database.query.frozen.DaoParam.param;

/**
 * ---------------------------------------------------------
 * - How to create a frozenQuery with Parameters
 * ---------------------------------------------------------
 */
@Component
public class FrozenQueryWithParameters extends ServiceBase<List<String>> {

    private FrozenDataBaseQueryField<Customer, String> frozenQuery ;

    @PostConstruct
    public void init(){
        frozenQuery = db.select(tabCustomer.colFirstName())
                        .whereLess(tabCustomer.colID(), param(1))
                        .freezeQuery();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, FrozenQueryWithParameters.class.getName());
    }

    @Override
    public List<String> call() {
        return frozenQuery.withParameters(10).findMany();
    }


}
