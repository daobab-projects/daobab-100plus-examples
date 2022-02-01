package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * NoHeapBuffer
 * ---------------------------------------------------------
 */
@Component
public class NoHeapBuffer extends ServiceBase<Void> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, NoHeapBuffer.class.getName());
    }

    @Override
    public Void call() {

        var noHeap=db.select(tabFilm).toNoHeap();

        noHeap.select(tabFilm).whereLess(tabFilm.colFilmId(),4).findMany().forEach(c->log.info(c.toJSON()));
        db.select(tabFilm).whereLess(tabFilm.colFilmId(),4).findMany().forEach(c->log.info(c.toJSON()));

        return null;
    }




}
