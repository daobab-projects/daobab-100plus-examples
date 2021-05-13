package io.daobab.demo.example.e_expert;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Query Optimisation
 * ---------------------------------------------------------
 * - Daobab reorders where clause to make the query execution faster
 */
@Component
public class QueryOptimisation extends ServiceBase<Void> {

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
