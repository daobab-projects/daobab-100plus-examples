package io.daobab.demo.example.b_beginner;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Chained Setters and Insert
 * ---------------------------------------------------------
 */
@Component
public class ChainedSettingAndInsert extends ServiceBase<Film> {


    @Override
    public Film call() {
        var film = new Film()
                .setFilmId(3999)
                .setLastUpdate(toCurrentTimestamp())
                .setDescription("Description")
                .setReleaseYear(toCurrentDateSQL())
                .setReplacementCost(toBD(10.10))
                .setRentalDuration(10)
                .setRentalRate(toBD(1))
                .setLength(120)
                .setLanguageId(1)
                .setTitle("Test")
                .insert(db);

        film.delete(db);
        return film;


    }


}
