package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Statistic
 * ---------------------------------------------------------
 */
@Component
public class Statistic extends ServiceBase<Void> implements MetaDataTables {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Statistic.class.getName());
    }

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

        rs.forEach(c->log.info(c.toJson()));
        return null;
    }


}
