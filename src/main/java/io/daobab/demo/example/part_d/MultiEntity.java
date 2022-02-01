package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.buffer.multi.MultiEntityTarget;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * MultiEntityTarget
 * ---------------------------------------------------------
 */
@SuppressWarnings("DuplicatedCode")
@Component
public class MultiEntity extends ServiceBase<Void> implements MetaDataTables, FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, MultiEntity.class.getName());
    }

    @Override
    public Void call() {

        //Building a multiTarget on three Entities
        var mt=new MultiEntityTarget(
                db.select(tabFilmActor).whereEqual(tabFilmActor.colFilmId(),1).findMany(),
                db.select(tabFilmCategory).whereEqual(tabFilmCategory.colFilmId(),1).findMany(),
                db.select(tabFilmText).whereEqual(tabFilmText.colFilmId(),1).findMany());

        //queries...
        var cn1=mt.select(tabFilmActor).countAny();
        var cn2=mt.select(tabFilmCategory).countAny();
        var cn3=mt.select(tabFilmText).countAny();

        //results...
        log.info(toString(cn1));
        log.info(toString(cn2));
        log.info(toString(cn3));


        return null;
    }


}
