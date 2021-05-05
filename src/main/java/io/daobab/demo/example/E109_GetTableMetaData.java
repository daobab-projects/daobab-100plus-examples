package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.target.database.JdbcType;
import io.daobab.target.meta.MetaSpecificsTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Protection against accidental delete
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class E109_GetTableMetaData extends ServiceBase<Void> implements MetaSpecificsTables {


    @Override
    public Void call() {
        db.getMetaData()
                .select(tabMetaColumn.colTableColumnName(),tabMetaColumn.colColumnSize())
                .whereEqual(tabMetaColumn.colDatatype(), JdbcType.VARCHAR)
                .orderAscBy(tabMetaColumn.colTableColumnName())
                .forEach(c->log.info(c.toJSON()));
        return null;
    }


}
