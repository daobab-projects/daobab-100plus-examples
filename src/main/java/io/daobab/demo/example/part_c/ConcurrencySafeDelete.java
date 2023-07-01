package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Concurrency Safe Delete
 * ---------------------------------------------------------
 * - How to use concurrency safe delete.
 * In this example each row is deleted into separated transaction.
 * Records are not locked by big transaction.
 */
@Component
public class ConcurrencySafeDelete extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ConcurrencySafeDelete.class.getName());
    }


    @Override
    public Void call() {
        var f = tabFilm;

        //This may create deadlocks
//     Delete.from(db,f)
//             .whereGreater(f.colFilmId(),2000)
//             .execute();

        db.select(f)
                .whereGreater(f.colFilmId(), 2000)
                .findMany()
                .forEach(d -> d.delete(db));


        return null;
    }


}
