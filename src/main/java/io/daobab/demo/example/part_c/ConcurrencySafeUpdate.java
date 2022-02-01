package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
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
public class ConcurrencySafeUpdate extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ConcurrencySafeUpdate.class.getName());
    }

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
                .findMany()
                .forEach(c -> c.setLastUpdate(toCurrentTimestamp()).update(db, f.colLastUpdate()));
        return null;
    }


}
