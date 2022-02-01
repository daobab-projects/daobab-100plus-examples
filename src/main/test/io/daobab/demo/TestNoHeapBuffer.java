package io.daobab.demo;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.model.Plate;
import io.daobab.target.database.query.DataBaseQueryField;
import io.daobab.target.buffer.noheap.NoHeapEntities;
import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.database.connection.JdbcType;
import io.daobab.target.database.meta.table.MetaColumn;
import io.daobab.target.database.meta.table.MetaEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TestNoHeapBuffer implements SakilaTables, FunctionWhispererH2 {


    private final Logger log = LoggerFactory.getLogger("Test");
    @Autowired
    private SakilaDataBase db;

    @Test
    void test01(){

        var buffer=new NoHeapEntities<>(db.select(tabActor).findMany());

        var res2=buffer.select(tabActor.colFirstName(),tabActor.colLastName())
                .where(or()
                    .like(tabActor.colFirstName(),"%A%")
                    .like(tabActor.colFirstName(),"%G%"))
                .findMany();

        log.info(""+res2.size());

        }


}
