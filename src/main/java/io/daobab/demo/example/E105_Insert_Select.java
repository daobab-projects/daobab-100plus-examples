package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Insert Select
 * ---------------------------------------------------------
 * - Example demonstrates, how to insert table rows based on compliant select.
 * Good practice to move data to archive table for example.
 * Insert and select should point on the same database.
 */
@Component
public class E105_Insert_Select extends ServiceBase<Void> {


    @Override
    public Void call() {
        db.insert(tabFilm)
                //inner select provides a compliant entity or compliant bunch of columns
                .select(db.select(tabFilm)
                        .whereLess(tabFilm.colFilmId(), 10))
                .execute(false);
        return null;
    }


}
