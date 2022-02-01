package io.daobab.demo.meta;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.meta.MetaDataTables;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get ordered all column names from a schema
 * ---------------------------------------------------------
 */
@Component
public class GetAllColumnNames extends ServiceBase<List<String>> implements MetaDataTables {

    @Override
    public List<String> call() {
        return db.getMetaData()
                .select(tabMetaColumn.colTableName())
                .orderAscBy(tabMetaColumn.colTableName())
                .findMany();
    }


}
