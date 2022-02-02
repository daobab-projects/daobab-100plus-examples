package io.daobab.demo.meta;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get ordered all table names from a schema
 * ---------------------------------------------------------
 */
@Component
public class GetAllTableNames extends ServiceBase<List<String>> implements MetaDataTables {

    @Override
    public List<String> call() {

        return db.getMetaData()
                .select(tabMetaTable.colTableName())
                .orderAscBy(tabMetaTable.colTableName())
                .findMany();
    }


}
