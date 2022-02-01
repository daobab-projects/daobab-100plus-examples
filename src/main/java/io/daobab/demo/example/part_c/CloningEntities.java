package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entities Cloning
 * ---------------------------------------------------------
 */
@Component
public class CloningEntities extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, CloningEntities.class.getName());
    }

    @Override
    public Void call() {
        var src = db.select(tabFilm)
                .whereLessOrEqual(tabFilm.colID(), 10)
                .findMany();
        var clone = src.clone();

        log.info("src size:" + src.size() + ", clone size:" + clone.size());

        return null;

    }


}
