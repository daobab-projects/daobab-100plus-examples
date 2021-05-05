package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Entity;
import io.daobab.model.TableColumn;
import io.daobab.statement.FunctionWhisperer;
import io.daobab.target.meta.MetaSpecificsTables;
import io.daobab.target.multi.MultiEntityTarget;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.lang.String.format;


/**
 * ---------------------------------------------------------
 * Protection against accidental delete
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@SuppressWarnings("DuplicatedCode")
@Component
public class E114_MultiEntityTarget extends ServiceBase<Void> implements MetaSpecificsTables, FunctionWhisperer {


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
