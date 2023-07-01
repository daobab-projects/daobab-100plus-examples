package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * NonHeapBuffer
 * ---------------------------------------------------------
 */
@Component
public class NonHeapBuffer extends ServiceBase<Void> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, NonHeapBuffer.class.getName());
    }

    @Override
    public Void call() {

        var noHeap = db.select(tabFilm).toNonHeap();

        noHeap.select(tabFilm).whereLess(tabFilm.colFilmId(), 4).findMany().forEach(c -> log.info(c.toJson()));
        db.select(tabFilm).whereLess(tabFilm.colFilmId(), 4).findMany().forEach(c -> log.info(c.toJson()));

        return null;
    }


}
