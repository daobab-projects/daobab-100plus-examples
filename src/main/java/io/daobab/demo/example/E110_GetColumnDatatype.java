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
public class E110_GetColumnDatatype extends ServiceBase<Void> implements MetaSpecificsTables {


    @Override
    public Void call() {
        var rs= db.getMetaData()
                .getColumnDataType(tabFilm.colTitle());

        log.info(rs==null?"null":rs.toString());
        return null;
    }


}
