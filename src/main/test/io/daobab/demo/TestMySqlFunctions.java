package io.daobab.demo;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.statement.function.FunctionWhispererMySql;
import io.daobab.statement.function.base.DatePeriod;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestMySqlFunctions implements SakilaTables, FunctionWhispererMySql {

    private final Logger log = LoggerFactory.getLogger("Test");

    @Autowired
    private SakilaDataBase db;

    @Test
    void test(){
        log.info(
                db.select(addDate(tabRental.colRentalDate(),interval(14, DatePeriod.MINUTE)))
                .from(tabRental)
                .toSqlQuery());

    }
}
