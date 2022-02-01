package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.enhanced.EnglishFilm;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Enhanced Entity
 * ---------------------------------------------------------
 * - How to enhance Entity (see into EnglishFilm entity)
 */
@Component
public class EnhancedEntity extends ServiceBase<Entities<EnglishFilm>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, EnhancedEntity.class.getName());
    }

    @Override
    public Entities<EnglishFilm> call() {
        var t = tabEnglishFilm;
        return db.select(t)
                .whereNotNull(t.colTitle())
                .limitBy(5)
                .findMany();
    }


}
