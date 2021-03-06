package io.daobab.demo;

import io.daobab.demo.base.TestHelper;
import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.model.dummy.DummyColumnTemplate;
import io.daobab.result.Entities;
import io.daobab.statement.function.FunctionWhispererH2;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YourQueryTest implements SakilaTables, TestHelper, DummyColumnTemplate, FunctionWhispererH2 {

    private final Logger log = LoggerFactory.getLogger("Test");

    @Autowired
    private SakilaDataBase db;

    @Test
    void yourQuery() {
        var t = tabFilm;

        Entities<FilmActor> result2 = db.select(tabFilmActor)
                .join(tabFilm, tabFilmActor.colFilmId(),
                        and().equal(tabFilm.colReleaseYear(), toDateSQL("2020", "YYYY")))
                .findMany();
    }

    @Override
    public Logger getLog() {
        return log;
    }
}
