package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.column.ActorId;
import io.daobab.demo.dao.column.Description;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.dao.table.FilmActorKey;
import io.daobab.model.Table;
import io.daobab.model.TableColumn;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * ---------------------------------------------------------
 * Select Native Plate
 * ---------------------------------------------------------
 */
@Component
public class SelectByCompositeKey extends ServiceBase<FilmActor> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectByCompositeKey.class.getName());
    }

    @Override
    public FilmActor call() {

        var anotherEntity=new AnotherEntityHavingTheSameCompositeKeyColumns()
                .setActorId(1).setFilmId(1).setDescription("A description");

        return db.select(tabFilmActor)
                .whereEqual(tabFilmActor.colCompositeId(),anotherEntity)
                .findOne();
    }

    static class AnotherEntityHavingTheSameCompositeKeyColumns
            extends Table implements FilmActorKey<AnotherEntityHavingTheSameCompositeKeyColumns>,
            ActorId<AnotherEntityHavingTheSameCompositeKeyColumns, Integer>,
            FilmId<AnotherEntityHavingTheSameCompositeKeyColumns, Integer>,
            Description<AnotherEntityHavingTheSameCompositeKeyColumns, String>
    {
        @Override
        public String getEntityName() {
            return "AnotherEntityHavingTheSameCompositeKeyColumns";
        }

        @Override
        public List<TableColumn> columns() {
            return Arrays.asList(
                    new TableColumn(colActorId()).primaryKey().size(5),
                    new TableColumn(colFilmId()).primaryKey().size(5),
                    new TableColumn(colDescription()).primaryKey().size(50)
            );
        }
    }


}
