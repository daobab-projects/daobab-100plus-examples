package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Query Optimisation
 * ---------------------------------------------------------
 * - Daobab reorders where clause to make the query execution faster
 */
@Component
public class QueryOptimisation extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, QueryOptimisation.class.getName());
    }

    @Override
    public Void call() {

        db.select(tabFilm)
                .where(and()
                        .notNull(tabFilm.colLength())
                        .like(tabFilm.colDescription(), "%a%")
                        .equal(tabFilm.colID(), 10)
                ).findOne();

        return null;
    }


}
