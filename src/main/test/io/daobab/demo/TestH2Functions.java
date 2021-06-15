package io.daobab.demo;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.statement.function.FunctionWhispererH2;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestH2Functions implements SakilaTables, FunctionWhispererH2 {


    private final Logger log = LoggerFactory.getLogger("Test");
    @Autowired
    private SakilaDataBase db;

    @Test
    void testAscii(){
        var rs=db.select(ascii(tabFilm.colTitle()))
                .whereEqual(tabFilm.colID(), 1)
                .findOne();
        log.info(rs.toString());
    }
    @Test
    void testBitLength(){
        var rs=db.select(bitLength(tabFilm.colTitle()))
                .whereEqual(tabFilm.colID(), 1)
                .findOne();
        log.info(rs.toString());
    }

    @Test
    void testConcat(){
        db.select(concat(tabFilm.colTitle(),tabFilm.colDescription()))
            .whereEqual(tabFilm.colID(), 1)
            .findFirst()
            .ifPresent(log::info);
    }

    @Test
    void testConcatWs(){
        db.select(concatWs(" - ",tabFilm.colTitle(),tabFilm.colDescription()))
            .whereEqual(tabFilm.colID(), 1)
            .findFirst()
            .ifPresent(log::info);
    }

    @Test
    void testInstr(){
        db.select(instr(tabFilm.colTitle(),"DIN"))
                .whereEqual(tabFilm.colID(), 1)
                .findFirst()
                .ifPresent(c->log.info(c.toString()));
    }

    @Test
    void testInstr2(){
        db.select(instr(tabFilm.colTitle(),"DIN",4).cast(String.class))
                .whereEqual(tabFilm.colID(), 1)
                .findFirst()
                .ifPresent(c->log.info(c));
    }
    @Test
    void testASCII(){
        db.select(
                ascii(db.select(tabFilm.colDescription()).limitBy(1)))
                .limitBy(1)
                .findFirst()
                .ifPresent(c->log.info(c.toString()));
    }
}
