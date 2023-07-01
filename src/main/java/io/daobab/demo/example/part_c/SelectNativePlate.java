package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Native Plate
 * ---------------------------------------------------------
 */
@Component
public class SelectNativePlate extends ServiceBase<FlatPlate> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectNativePlate.class.getName());
    }

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
                .findOne().toFlat();
    }


}
