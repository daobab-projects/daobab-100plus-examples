package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.buffer.multi.QueryMultiEntityTarget;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * QueryMultiEntityTarget
 * ---------------------------------------------------------
 */
@SuppressWarnings("DuplicatedCode")
@Component
public class QueryMultiEntity extends ServiceBase<Void> implements MetaDataTables, FunctionWhispererH2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, QueryMultiEntity.class.getName());
    }

    @Override
    public Void call() {

        var mt= new QueryMultiEntityTarget();

        mt.register(db.select(tabFilmActor).whereEqual(tabFilmActor.colFilmId(),1));
        mt.register(db.select(tabFilmCategory).whereEqual(tabFilmCategory.colFilmId(),1));
        mt.register(db.select(tabFilmText).whereEqual(tabFilmText.colFilmId(),1));

        //queries...
        var c1=mt.select(tabFilmActor).countAny();
        var c2=mt.select(tabFilmCategory).countAny();
        var c3=mt.select(tabFilmText).countAny();

        //results...
        log.info(toString(c1));
        log.info(toString(c2));
        log.info(toString(c3));

        
        return null;
    }


}
