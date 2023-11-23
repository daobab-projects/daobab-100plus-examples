package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Replace Select
 * ---------------------------------------------------------
 * - Example demonstrates, how to replace table rows based on compliant select.
 * Good practice to move data to archive table for example.
 * <p>
 * <a href="https://dev.mysql.com/doc/refman/8.0/en/replace.html">...</a>
 * REPLACE works exactly like INSERT, except that if an old row in the table has the same value as a new row for a PRIMARY KEY or a UNIQUE index, the old row is deleted before the new row is inserted.
 * </p>
 * */
@Component
public class ReplaceSelect extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ReplaceSelect.class.getName());
    }

    @Override
    public Void call() {
        db.replace(tabFilm)
                //inner select provides a compliant entity or compliant bunch of columns
                .select(db.select(tabFilm)
                        .whereLess(tabFilm.colFilmId(), 10))
                .execute(false);
        return null;
    }


}
