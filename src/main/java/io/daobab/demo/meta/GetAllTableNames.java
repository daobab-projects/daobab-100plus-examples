package io.daobab.demo.meta;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.example.part_a.Count;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to get ordered all table names from a schema
 * ---------------------------------------------------------
 */
@Component
public class GetAllTableNames extends ServiceBase<List<String>> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(GetAllTableNames.class, Count.class.getName());
    }

    @Override
    public List<String> call() {

        return db.getMetaData()
                .select(tabMetaTable.colTableName())
                .orderAscBy(tabMetaTable.colTableName())
                .findMany();
    }


}
