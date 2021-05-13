package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.FunctionWhisperer;
import io.daobab.target.meta.MetaSpecificsTables;
import io.daobab.target.multi.QueryMultiEntityTarget;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * QueryMultiEntityTarget
 * ---------------------------------------------------------
 */
@SuppressWarnings("DuplicatedCode")
@Component
public class QueryMultiEntity extends ServiceBase<Void> implements MetaSpecificsTables, FunctionWhisperer {


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
