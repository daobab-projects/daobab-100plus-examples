package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Concurrency Safe Update
 * ---------------------------------------------------------
 * - How to use concurrency safe update.
 *   In this example each row is modified into separated transaction.
 *   Records are not locked by big transaction.
 */
@Component
public class E068_Concurrency_Safe_Update extends ServiceBase<Void> {


    @Override
    public Void call() {
        var f = tabFilm;

        //This may create deadlocks
//     Update.to(db,f).set(SetFields
//             .setColumn(f.colLastUpdate(),toCurrentTimestamp()))
//             .where(f.colFilmId(),LT,20)
//             .execute();

        db.select(f)
                .whereLess(f.colFilmId(), 20)
                .forEach(c -> c.setLastUpdate(toCurrentTimestamp()).update(db, f.colLastUpdate()));
        return null;
    }


}
