package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.statement.FunctionWhisperer;
import io.daobab.target.meta.MetaSpecificsTables;
import io.daobab.target.multi.MultiEntityTarget;
import org.springframework.stereotype.Component;

import static java.lang.String.format;


/**
 * ---------------------------------------------------------
 * MultiEntityTarget
 * ---------------------------------------------------------
 */
@SuppressWarnings("DuplicatedCode")
@Component
public class MultiEntity extends ServiceBase<Void> implements MetaSpecificsTables, FunctionWhisperer {


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
