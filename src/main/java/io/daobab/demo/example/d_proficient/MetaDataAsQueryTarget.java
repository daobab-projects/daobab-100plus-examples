package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.JdbcType;
import io.daobab.target.meta.MetaDataTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * MetaData as target
 * ---------------------------------------------------------
 */
@Component
public class MetaDataAsQueryTarget extends ServiceBase<Void> implements MetaDataTables {


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
