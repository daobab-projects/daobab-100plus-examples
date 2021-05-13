package io.daobab.demo.example.e_expert;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Linking Entities by Where
 * ---------------------------------------------------------
 * - How to use Where for linking Entities (instead og joins)
 */
@Component
public class LinkingEntitiesByWhere extends ServiceBase<FlatPlate> {


    @Override
    public FlatPlate call() {
        var f = tabFilm;
        var fc = tabFilmCategory;
        var c = tabCategory;

        return db.select(f.colTitle(), c.colName())
                .where(and()
                        .equal(f.colFilmId(), fc.colFilmId())
                        .equal(fc.colCategoryId(), c.colCategoryId())
                        .equal(f.colID(), 15))
                .findOneAsFlat();
    }


}
