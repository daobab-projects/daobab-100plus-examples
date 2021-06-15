package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.meta.MetaDataTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Statistic
 * ---------------------------------------------------------
 */
@Component
public class Statistic extends ServiceBase<Void> implements MetaDataTables {


    @Override
    public Void call() {


        db.enableStatisticCollecting(true);
        db.getStatisticCollector().setBufferSize(100);
        db.getStatisticCollector().ignoreSuccessful(true);
        db.getStatisticCollector().ignoreExecutionTimeBelow(5000);



//        db.getStatisticCollector().ignoreExecutionTimeBelow(1000000);
        db.select(tabFilm)
                .whereLess(tabFilm.colFilmId(),10)
                .findMany();

        db.select(tabFilm)
                .whereLess(tabFilm.colFilmId(),10)
                .findMany();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var rs=db.getStatistics().findMany();

        log.info(String.valueOf(rs.size()));

        rs.forEach(c->log.info(c.toJSON()));
        return null;
    }


}
