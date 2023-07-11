package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.condition.SetFields;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * ---------------------------------------------------------
 * Insert Select
 * ---------------------------------------------------------
 */
@Component
public class InsertDuplicatedKeyUpdate extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, InsertDuplicatedKeyUpdate.class.getName());
    }

    @Override
    public Void call() {
        db.insert(tabFilm)
                //inner select provides a compliant entity or compliant bunch of columns
                .select(db.select(tabFilm)
                        .whereLess(tabFilm.colFilmId(), 10))
                .onDuplicateKeyUpdate(new SetFields()
                        .setValue(tabFilm.colLastUpdate(), LocalDateTime.now())
                        .setValue(tabFilm.colDescription(), "done")
                        .setValue(tabFilm.colLength(), 20)
                )
                .execute(false);
        return null;
    }


}
