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
 * - How to unfreeze frozen Query
 * ---------------------------------------------------------
 */
@Component
public class UnfreezeFrozenQuery extends ServiceBase<List<String>> {

    private FrozenDataBaseQueryField<Customer, String> fistFrozenQuery;
    private FrozenDataBaseQueryField<Customer, String> secondFrozenQuery;

    @PostConstruct
    public void init() {
        fistFrozenQuery = db.select(tabCustomer.colFirstName())
                .whereLess(tabCustomer.colID(), param(1))
                .freezeQuery();

        var unfrozenQuery = fistFrozenQuery.unfreeze();

        var secondQuery = unfrozenQuery.orderDescBy(tabCustomer.colFirstName());

        secondFrozenQuery = secondQuery.freezeQuery();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, UnfreezeFrozenQuery.class.getName());
    }

    @Override
    public List<String> call() {
        return secondFrozenQuery.withParameters(10).findMany();
    }


}
