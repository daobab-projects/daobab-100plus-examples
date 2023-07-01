package io.daobab.demo;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.demo.dao.procedure.SomeIn;
import io.daobab.demo.dao.procedure.SomeOut;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.database.meta.MetaDataTables;
import io.daobab.target.database.meta.table.MetaEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class TestProcedureCall implements MetaDataTables, FunctionWhispererH2, SakilaTables {

    private final Logger log = LoggerFactory.getLogger("Test");

    @Autowired
    private SakilaDataBase db;

    @Test
    void test(){
        SomeIn in=new SomeIn("tgest",12);
        SomeOut out=db.callProcedure("test",in,new SomeOut());
    }

    @Test
    void test1(){

        var columns=tabFilm.columns().stream().map(TableColumn::getColumn).map(c->max(length(c)).as(c.getColumnName())).collect(Collectors.toList());

        var res=db.select(columns).findOne();
        log.info(res.toString());

        var metaColumn =db.getMetaDataForColumn(tabFilm.colTitle());

        log.info(metaColumn.getColumnSize().toString());

        var res2=db.select(tabFilm.colRentalRate())
                .groupBy(tabFilm.colRentalRate())
                .findMany();

        res2.forEach(c->log.info(c.toString()));
//        log.info(res.toJson());
    }


    @Test
    void test2(){
        var out=db.getMetaData();


        for (var metaTable:db.getMetaData().select(tabMetaTable.colTableName()).findMany()){

            var many=out.select(tabMetaColumn)
                    .whereEqual(tabMetaColumn.colTableName(),metaTable)
                    .findMany();

            MetaEntity entity=new MetaEntity(metaTable);

            List<Column<?,?,?>> tableColumns=many.stream()
                    .map(entity::addColumn)
                    .map(m->(Column<?,?,?>)m.getColumn())
                    .collect(Collectors.toList());

            var query=db.select(tableColumns).toSqlQuery();

            log.info(query);
        }


    }



    @Test
    void test3(){

        var optmeta=db.getMetaData().getMetaColumn(tabFilm.colFilmId());

        optmeta.ifPresent(c->log.info(c.toJson()));

        db.getMetaData().select(tabMetaIndex)
                .where(and()
                        .equal(tabMetaIndex.colColumnName(),tabFilm.colFilmId().getColumnName())
                        .equal(tabMetaIndex.colTableName(),tabFilm.colFilmId().getEntityName()))
                    .findMany().forEach(c->log.info(c.toJson()));



    }



}
