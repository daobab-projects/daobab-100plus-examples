package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native Plate
 * ---------------------------------------------------------
 * - How to use Select Native Plate
 */
@Component
public class E090_Select_Native_Plate extends ServiceBase<FlatPlate> {


    @Override
    public FlatPlate call() {
        var f = tabFilm;
        var fc = tabFilmCategory;
        var c = tabCategory;
        /**

         Select.one(db,f.colTitle(),c.colName())
         .join(fc,f.colFilmId())
         .join(c,fc.colCategoryId())
         .where(f.colID(),15)
         .resultAsFlat();

         */


        return db.nativeSelect(
                "select f.title,c.name from film f " +
                        "join film_category fc on fc.film_id=f.film_id " +
                        "join category c on c.category_id=fc.category_id " +
                        "where f.film_id=15",
                tabFilm.colTitle(), tabCategory.colName())
                .findOneAsFlat();
    }


}
