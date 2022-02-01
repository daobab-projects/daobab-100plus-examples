package io.daobab.demo.meta;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.meta.MetaDataTables;
import io.daobab.target.meta.table.MetaIndex;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get unique indexes
 * ---------------------------------------------------------
 */
@Component
public class GetUniqueIndexes extends ServiceBase<List<MetaIndex>> implements MetaDataTables {

    @Override
    public List<MetaIndex> call() {
        return db.getMetaData()
                .select(tabMetaIndex)
                .whereEqual(tabMetaIndex.colUnique(),true)
                .findMany();
    }


}
