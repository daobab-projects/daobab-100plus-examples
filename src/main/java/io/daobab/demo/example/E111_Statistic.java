package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.target.meta.MetaSpecificsTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Protection against accidental delete
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class E111_Statistic extends ServiceBase<Void> implements MetaSpecificsTables {


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

        System.out.println(rs.size());

        rs.forEach(c->log.info(c.toJSON()));
        return null;
    }


}
