package io.daobab.demo;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.target.buffer.bytebyffer.EntityByteBuffer;
import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.database.meta.MetaDataTables;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestJoin implements SakilaTables, MetaDataTables {


    private final Logger log = LoggerFactory.getLogger("Test");
    @Autowired
    private SakilaDataBase db;

    @Test
    void test01(){

        var res=db.getMetaData().select(tabMetaTable.colTableName())
                .join(tabMetaColumn,tabMetaTable.colTableName(),and().equal(tabMetaColumn.colTableName(),"ACTOR"))
//                .whereEqual(tabMetaColumn.colColumnName(),"LAST_NAME")
                .findOne();

//        res.forEach(p->log.info(p.toJSON()));
        log.info(res);

        }


}
