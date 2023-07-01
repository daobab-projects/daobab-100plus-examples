package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Entity;
import io.daobab.model.TableColumn;
import io.daobab.target.database.meta.MetaDataTables;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.lang.String.format;


/**
 * ---------------------------------------------------------
 * Schemas Comparator
 * ---------------------------------------------------------
 */
@Component
public class SchemaComparator extends ServiceBase<Void> implements MetaDataTables {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SchemaComparator.class.getName());
    }

    @Override
    public Void call() {
        var tablesInSchema = db.getTables().stream()
                .map(Entity::entityClass)
                .map(Class::getName)
                .collect(Collectors.toList());

        var columnsInSchema = db.getTables().stream()
                .flatMap(t -> t.columns().stream())
                .map(TableColumn::getColumn)
                .map(c -> c.getEntityClass().getName() + "." + c.getColumnName())
                .collect(Collectors.toList());

        var notGeneratedTables = db.getMetaData()
                .select(tabMetaTable.colTableName())
                .whereNotInFields(tabMetaTable.colTableName(), tablesInSchema)
                .findMany();

        var notGeneratedColumns = db.getMetaData()
                .select(tabMetaColumn.colTableColumnName())
                .whereNotInFields(tabMetaColumn.colTableColumnName(), columnsInSchema)
                .orderAscBy(tabMetaColumn.colTableColumnName())
                .findMany();

        log.info(format("there is %s tables which are not generated.", notGeneratedTables.size()));
        log.info(format("there is %s columns which are not generated.", notGeneratedColumns.size()));

        if (notGeneratedTables.isEmpty() && notGeneratedColumns.isEmpty()) {
            log.info("The schema is fully compliant with the generated Daobab classes");
        }
        return null;
    }


}
