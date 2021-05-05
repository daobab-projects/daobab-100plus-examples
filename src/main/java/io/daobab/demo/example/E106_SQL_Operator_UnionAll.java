package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * SQL Operator Union
 * ---------------------------------------------------------
 * - Example haw to use 'union'
 */
@Component
public class E106_SQL_Operator_UnionAll extends ServiceBase<List<Integer>> {


    @Override
    public List<Integer> call() {
        return db.select(tabFilmActor.colFilmId())
                .whereLess(tabFilmActor.colFilmId(), 10)
                .union(db.select(tabFilmCategory.colFilmId())
                        .whereGreater(tabFilmCategory.colFilmId(), 990))
                .findMany();
    }


}
