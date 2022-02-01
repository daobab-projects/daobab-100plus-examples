package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * SQL Operator Union
 * ---------------------------------------------------------
 * - Example haw to use 'union'
 */
@Component
public class UnionAll extends ServiceBase<List<Integer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, UnionAll.class.getName());
    }

    @Override
    public List<Integer> call() {
        return db.select(tabFilmActor.colFilmId())
                .whereLess(tabFilmActor.colFilmId(), 10)
                .union(db.select(tabFilmCategory.colFilmId())
                        .whereGreater(tabFilmCategory.colFilmId(), 990))
                .findMany();
    }


}
