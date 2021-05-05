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
public class E108_GetTableMetaData extends ServiceBase<Void> implements MetaSpecificsTables {


    @Override
    public Void call() {
        var t=tabMetaColumn;
        var rs= db.getMetaData()
                .select(t.colTableColumnName(),t.colColumnSize())
                .whereEqual(t.colDatatype(), JdbcType.VARCHAR)
                .orderAscBy(t.colTableColumnName())
                .findMany();

        rs.forEach(c->log.info(c.toJSON()));
        return null;
    }


}
