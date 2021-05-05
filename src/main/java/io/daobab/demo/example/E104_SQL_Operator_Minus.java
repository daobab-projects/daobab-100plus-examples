package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * SQL Operator Minus
 * ---------------------------------------------------------
 * - Example haw to use 'minus'
 */
@Component
public class E104_SQL_Operator_Minus extends ServiceBase<List<Integer>> {


    @Override
    public List<Integer> call() {
        return db.select(tabFilmActor.colFilmId())
                .whereLess(tabFilmActor.colFilmId(), 110)
                .minus(db.select(tabFilmCategory.colFilmId())
                        .whereGreater(tabFilmCategory.colFilmId(), 10))
                .findMany();

    }


}
