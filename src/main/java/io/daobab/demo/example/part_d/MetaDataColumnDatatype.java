package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Get column datatype
 * ---------------------------------------------------------
 */
@Component
public class MetaDataColumnDatatype extends ServiceBase<Void> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, MetaDataColumnDatatype.class.getName());
    }

    @Override
    public Void call() {
        var rs = db.getMetaData()
                .getColumnDataType(tabFilm.colTitle());

        log.info(rs == null ? "null" : rs.toString());
        return null;
    }


}
