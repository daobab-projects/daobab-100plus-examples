package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * ---------------------------------------------------------
 * SQL Operator Minus
 * ---------------------------------------------------------
 * - Example haw to use 'minus'
 */
@Component
public class Minus extends ServiceBase<List<Integer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Minus.class.getName());
    }

    @Override
    public List<Integer> call() {
        return db.select(tabFilmActor.colFilmId())
                .whereLess(tabFilmActor.colFilmId(), 110)
                .minus(db.select(tabFilmCategory.colFilmId())
                        .whereGreater(tabFilmCategory.colFilmId(), 10))
                .findMany();

    }


}
