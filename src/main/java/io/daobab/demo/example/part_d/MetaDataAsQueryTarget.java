package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.target.database.connection.JdbcType;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * MetaData as target
 * ---------------------------------------------------------
 */
@Component
public class MetaDataAsQueryTarget extends ServiceBase<Void> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, MetaDataAsQueryTarget.class.getName());
    }

    @Override
    public Void call() {
        var t=tabMetaColumn;
        var rs= db.getMetaData()
                .select(t.colTableColumnName(),t.colColumnSize())
                .whereEqual(t.colDatatype(), JdbcType.VARCHAR)
                .orderAscBy(t.colTableColumnName())
                .findMany();

        rs.forEach(c->log.info(c.toJson()));
        return null;
    }


}
