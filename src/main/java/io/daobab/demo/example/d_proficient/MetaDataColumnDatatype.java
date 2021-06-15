package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.meta.MetaDataTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Get column datatype
 * ---------------------------------------------------------
 */
@Component
public class MetaDataColumnDatatype extends ServiceBase<Void> implements MetaDataTables {


    @Override
    public Void call() {
        var rs= db.getMetaData()
                .getColumnDataType(tabFilm.colTitle());

        log.info(rs==null?"null":rs.toString());
        return null;
    }


}
