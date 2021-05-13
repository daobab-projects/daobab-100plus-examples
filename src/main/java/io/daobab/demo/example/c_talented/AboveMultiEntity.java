package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.base.InMemoryFilm;
import io.daobab.demo.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to use AboveMultiEntityTarget
 * ---------------------------------------------------------
 */
@Component
public class AboveMultiEntity extends ServiceBase<List<Film>> {

    @Autowired
    private InMemoryFilm inMemoryFilm;

    @Override
    public List<Film> call() {
        var f = tabFilm;

        return inMemoryFilm.select(f)
                .whereAnd(a -> a
                        .less(f.colFilmId(), 100)
                        .equal(f.colSpecialFeatures(), "Deleted Scenes")
                        .greater(f.colReplacementCost(), toBigDecimal(20))
                )
                .orderDescBy(f.colDescription())
                .findMany();

    }


}
