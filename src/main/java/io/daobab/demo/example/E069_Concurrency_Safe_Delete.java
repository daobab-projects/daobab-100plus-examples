package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Concurrency Safe Delete
 * ---------------------------------------------------------
 * - How to use concurrency safe delete.
 *   In this example each row is deleted into separated transaction.
 *   Records are not locked by big transaction.
 */
@Component
public class E069_Concurrency_Safe_Delete extends ServiceBase<Void> {


    @Override
    public Void call() {
        var f = tabFilm;

        //This may create deadlocks
//     Delete.from(db,f)
//             .whereGreater(f.colFilmId(),2000)
//             .execute();

        db.select(f)
                .whereGreater(f.colFilmId(), 2000)
                .forEach(d -> d.delete(db));


        return null;
    }


}
