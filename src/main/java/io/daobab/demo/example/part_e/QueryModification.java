package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Entity;
import io.daobab.target.database.query.DataBaseQueryBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * QueryModificator
 * ---------------------------------------------------------
 * Daobab Query is an objet and may be modified
 */
@Component
public class QueryModification extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, QueryModification.class.getName());
    }

    @Override
    public Void call() {
        var query1=db.select(tabFilm).orderAscBy(tabFilm.colFilmId());
        var query2=db.select(tabFilm.colTitle()).orderAscBy(tabFilm.colFilmId());
        var query3=db.select(tabFilm.colTitle(),tabFilm.colDescription()).orderAscBy(tabFilm.colFilmId());

        var result1=applyLimit(query1).findMany().size();
        var result2=applyLimit(query2).findMany().size();
        var result3=applyLimit(query3).findMany().size();

        log.info("result 1: {}",result1);
        log.info("result 2: {}",result2);
        log.info("result 3: {}",result3);
        return null;
    }

    public <Q extends DataBaseQueryBase<E,Q>,E extends Entity,F> Q applyLimit(Q query) {
        return query.limitBy(5);
    }


}
