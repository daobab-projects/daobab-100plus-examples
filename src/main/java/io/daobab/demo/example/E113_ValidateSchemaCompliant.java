package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.TableColumn;
import io.daobab.target.database.JdbcType;
import io.daobab.target.meta.MetaSpecificsTables;
import io.daobab.target.meta.table.MetaColumn;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;


/**
 * ---------------------------------------------------------
 * Protection against accidental delete
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class E113_ValidateSchemaCompliant extends ServiceBase<Void> implements MetaSpecificsTables {


    @Override
    public Void call() {
        var tablesInSchema=db.getTables().stream()
                .map(Entity::getEntityName)
                .collect(Collectors.toList());

        var columnsInSchema=db.getTables().stream()
                .flatMap(t->t.columns().stream())
                .map(TableColumn::getColumn)
                .map(c->c.getEntityName()+"."+c.getColumnName())
                .collect(Collectors.toList());

        var notGeneratedTables=db.getMetaData()
                .select(tabMetaTable.colTableName())
                .whereNotIn(tabMetaTable.colTableName(),tablesInSchema)
                .findMany();

        var notGeneratedColumns=db.getMetaData()
                .select(tabMetaColumn.colTableColumnName())
                .whereNotIn(tabMetaColumn.colTableColumnName(), columnsInSchema)
                .orderAscBy(tabMetaColumn.colTableColumnName())
                .findMany();

        log.info(format("there is %s tables which are not generated.",notGeneratedTables.size()));
        log.info(format("there is %s columns which are not generated.",notGeneratedColumns.size()));

        if (notGeneratedTables.isEmpty() && notGeneratedColumns.isEmpty()){
            log.info("The schema is fully compliant with the generated Daobab classes");
        }
        return null;
    }


}
