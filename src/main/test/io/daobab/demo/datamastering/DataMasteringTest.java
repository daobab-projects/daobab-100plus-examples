package io.daobab.demo.datamastering;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.demo.dao.table.Rental;
import io.daobab.statement.function.FunctionWhispererMySql;
import io.daobab.statement.function.base.DatePeriod;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * This example refers to the DataMastering test created by Cris Simpkins (https://chris.simpkins.org/)
 * https://github.com/dr-cs/databases/blob/master/exercises/sakila-queries-answers.sql
 */
@SpringBootTest
@SuppressWarnings("java:S2699")
class DataMasteringTest implements SakilaTables, FunctionWhispererMySql {

    private final Logger log = LoggerFactory.getLogger("Test");
    @Autowired
    private SakilaDataBase db;

    //Which actors have the first name 'Scarlett'
    @Test
    void test01() {
        db.select(tabActor).whereEqual(tabActor.colFirstName(), "Scarlet").findMany();
    }

    //Which actors have the last name 'Johansson'
    @Test
    void test02() {
        db.select(tabActor).whereLike(tabActor.colFirstName(), "Johansson").findMany();
    }

    //How many distinct actors last names are there?
    @Test
    void test03() {
        db.select(count(distinct(tabActor.colLastName()))).findOne();
    }

    //Which last names are not repeated?
    @Test
    void test04() {
        db.select(tabActor.colLastName())
                .groupBy(tabActor.colLastName())
                .havingEqual(count(tabActor), 1L)
                .logQuery()
                .findMany();

        //db.select(count(tabActor)).findMany();
    }

    //Which last names appear more than once?
    @Test
    void test05() {
        db.select(tabActor.colLastName())
                .groupBy(tabActor.colLastName())
                .havingEqual(count(tabActor), 1L)
                .findMany();
    }

    @Test
    //Which actor has appeared in the most films?
    void test06() {
        var a = tabActor;
        var rs = db.select(a.colActorId(), a.colFirstName(), a.colLastName(), count(a.colActorId()).as("film_count"))
                .join(tabFilmActor, a.colID())
                .groupBy(a.colActorId())
                .orderDescBy("film_count")
                .limitBy(1)
                .findOne();

        log.info(rs.toJson());
    }

    //Is 'Academy Dinosaur' available for rent from Store 1?
    //Step 1: which copies are at Store 1?
    @Test
    void test07() {
        var f = tabFilm;
        var s = tabStore;
        var i = tabInventory;
        var rs = db.select(f.colID(), f.colTitle(), s.colID(), i.colID())
                .from(i)
                .join(s, i.colStoreId())
                .join(f, i.colFilmId())
                .where(and()
                        .equal(f.colTitle(), "Academy Dinosaur")
                        .equal(s.colStoreId(), 1))
                .findOne();
    }

    //Step 2: pick an inventory_id to rent:
    @Test
    void test08() {
        var f = tabFilm;
        var r = tabRental;
        var s = tabStore;
        var i = tabInventory;
        var rs = db.select(i.colID())
                .join(f, i.colFilmId())
                .join(s, i.colStoreId())
                .join(r, i.colInventoryId())
                .where(and()
                        .equal(f.colTitle(), "Academy Dinosaur")
                        .equal(s.colStoreId(), 1)
                        .notIn(i.colID(),
                                db.select(r.colInventoryId()).whereIsNull(r.colRentalDate()))
                ).toSqlQuery();

        log.info(rs);
    }

    //Insert a record to represent Mary Smith renting 'Academy Dinosaur' from Mike Hillyer at Store 1 today .
    @Test
    void test09() {
        new Rental()
                .setRentalDate(LocalDateTime.now())
                .setInventoryId(toBD(1))
                .setCustomerId(1)
                .setStaffId(1)
                .setLastUpdate(LocalDateTime.now())
                .insert(db);
    }

    //When is 'Academy Dinosaur' due?
    //Step 1: what is the rental duration?
    @Test
    void test10() {
        db.select(tabFilm.colRentalDuration())
                .whereEqual(tabFilm.colFilmId(), 1)
                .findOne();
    }

    //Step 2: Which rental are we referring to -- the last one.
    @Test
    void test11() {
        db.select(tabRental.colRentalId())
                .orderDescBy(tabRental.colRentalId())
                .limitBy(1)
                .findOne();
    }

    //Step 3: add the rental duration to the rental date.
    @Test
    void test12() {
        var rs = db.select(tabRental.colRentalDate(),
                        sum(tabRental.colRentalDate(), interval(tabRental.colReturnDate(), 1, DatePeriod.DAY)).as("due_date"))
                .from(tabRental)
                .whereEqual(tabRental.colRentalId(),
                        db.select(tabRental.colRentalId()).orderBy(tabRental.colID()).limitBy(1))
                .toSqlQuery();

        log.info(rs);
    }

    //What is that average length of all the films in the sakila DB?
    @Test
    void test13() {
        db.select(avg(tabFilm.colLength())).findOne();
    }

    @Test
        //Which film categories are long?
    void test15() {
        var rs = db.select(tabCategory.colName(), avg(tabFilm.colLength()).as("Length"))
                .from(tabFilm)
                .join(tabFilmCategory, tabFilm.colFilmId())
                .join(tabCategory, tabFilmCategory.colCategoryId())
                .groupBy(tabCategory.colName())
                .havingGreater(avg(tabFilm.colLength()), db.select(avg(tabFilm.colLength())))
                .orderDescBy("Length")
                .findMany();

        log.info(rs.toJson());
    }

    @Test
        //Why does this query return the empty set?
    void test16() {
        //Daobab prevents from typing this invalid query
        //db.select(tabFilm).joinPk(tabInventory.colInventoryId())
    }
}
