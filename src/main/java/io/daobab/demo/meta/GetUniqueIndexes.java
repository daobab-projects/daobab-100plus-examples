package io.daobab.demo.meta;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.example.part_a.Count;
import io.daobab.target.database.meta.MetaDataTables;
import io.daobab.target.database.meta.table.MetaIndex;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get unique indexes
 * ---------------------------------------------------------
 */
@Component
public class GetUniqueIndexes extends ServiceBase<List<MetaIndex>> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(GetUniqueIndexes.class, Count.class.getName());
    }

    @Override
    public List<MetaIndex> call() {
        return db.getMetaData()
                .select(tabMetaIndex)
                .whereEqual(tabMetaIndex.colUnique(),true)
                .findMany();
    }


}
