package io.daobab.demo.example;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.example.base.InMemoryFilm;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * InMemory Buffer
 * ---------------------------------------------------------
 * - How to use InMemory Buffer
 */
@Component
public class E066_InMemory_Buffer extends ServiceBase<List<Film>> {

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
