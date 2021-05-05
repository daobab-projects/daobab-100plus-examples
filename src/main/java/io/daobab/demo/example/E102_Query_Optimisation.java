package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Dual;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Query Optimisation
 * ---------------------------------------------------------
 * - Daobab reorders where clause to make the query execution faster
 */
@Component
public class E102_Query_Optimisation extends ServiceBase<Void> {

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
