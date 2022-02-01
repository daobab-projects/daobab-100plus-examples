package io.daobab.demo;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@SpringBootTest
class TestNoHeap implements SakilaTables {


    private final Logger log = LoggerFactory.getLogger("Test");
    @Autowired
    private SakilaDataBase db;

    @Test
    void test01(){

        var noHeap=db.select(tabRental)
                .findMany().toNoHeap();

        long start=System.currentTimeMillis();
        var res = noHeap.select(tabRental.colID(), tabRental.colLastUpdate())
                .where(or(
                        and().greater(tabRental.colID(), new BigDecimal(5))
                                .less(tabRental.colID(), new BigDecimal(15))
                                .notEqual(tabRental.colID(), new BigDecimal(9)
                                ))
                        .or(
                                and().greater(tabRental.colID(), new BigDecimal(25))
                                        .less(tabRental.colID(), new BigDecimal(35))
                                        .notEqual(tabRental.colID(), new BigDecimal(29))
                                )
                )
                .findMany();

        long stop=System.currentTimeMillis();
        log.info("************** TIME:"+(stop-start));
        res.forEach(p->log.info(p.toJSON()));
//        res.forEach(log::info);
//        log.info(""+res);
        }

    @Test
    void test02(){

        var many=db.select(tabRental)
                .findMany();

        long start=System.currentTimeMillis();
        var res=many.stream()
//                .filter(e->e.getId().compareTo(new BigDecimal(5))>1)
                .filter(e->e.getId().compareTo(new BigDecimal(5))==0)
                .limit(1)
                .collect(Collectors.toSet());

        long stop=System.currentTimeMillis();
        log.info("************** TIME:"+(stop-start));
       // res.forEach(p->log.info(p.toJSON()));
//        res.forEach(log::info);
//        log.info(""+res);

    }

    @Test
    void test03(){

        var many=db.select(tabRental)
                .findMany();

        long start=System.currentTimeMillis();
        var res=many.stream()
                .filter( e->
                        (e.getId().compareTo(new BigDecimal(5))>0&&
                        e.getId().compareTo(new BigDecimal(15))<0&&
                        e.getId().compareTo(new BigDecimal(9))!=0)||
                (e.getId().compareTo(new BigDecimal(25))>0&&
                        e.getId().compareTo(new BigDecimal(35))<0&&
                        e.getId().compareTo(new BigDecimal(29))!=0))
//                .limit(1)
                .collect(Collectors.toSet());

        long stop=System.currentTimeMillis();
        log.info("************** TIME:"+(stop-start));
         res.forEach(p->log.info(p.toJSON()));
//        res.forEach(log::info);
//        log.info(""+res);

    }

}
