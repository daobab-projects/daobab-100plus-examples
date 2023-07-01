package io.daobab.demo;

import io.daobab.demo.base.TestHelper;
import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.model.dummy.DummyColumnTemplate;
import io.daobab.target.buffer.single.Entities;
import io.daobab.statement.function.FunctionWhispererH2;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Year;

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
                        and().equal(tabFilm.colReleaseYear(), LocalDate.of(2020,1,1)))
                .findMany();
    }

    @Override
    public Logger getLog() {
        return log;
    }
}
