package io.daobab.demo.example.e_expert;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.*;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.query.base.Query;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ---------------------------------------------------------
 * QueryModificator
 * ---------------------------------------------------------
 * Daobab Query is an objet and may be modified
 */
@Component
public class QueryModification extends ServiceBase<Void> {


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

    public <Q extends Query<E,Q>,E extends Entity,F> Q applyLimit(Q query) {
        return query.limitBy(5);
    }


}
