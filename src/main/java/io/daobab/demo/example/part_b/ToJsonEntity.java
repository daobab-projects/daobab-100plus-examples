package io.daobab.demo.example.part_b;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.example.part_a.Count;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entity to JSON
 * ---------------------------------------------------------
 * - How to use internal toJson() method into Entity
 */
@Component
public class ToJsonEntity extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(ToJsonEntity.class, Count.class.getName());
    }

    @Override
    public Void call() {
        var film = db.findOneByPk(tabFilm, 1);
        log.info(film.toJson());
        return null;
    }


}
