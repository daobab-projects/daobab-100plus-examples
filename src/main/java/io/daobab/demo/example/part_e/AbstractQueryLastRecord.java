package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.*;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ---------------------------------------------------------
 * Abstract query
 * ---------------------------------------------------------
 * - How to use abstract queries
 */
@Component
public class AbstractQueryLastRecord extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, AbstractQueryLastRecord.class.getName());
    }

    @Override
    public Void call() {
        Film lastRecordFilm = findTheYoungestRecord(tabFilm.colLastUpdate());
        Actor lastRecordActor = findTheYoungestRecord(tabActor.colLastUpdate());
        Rental lastRecordRental = findTheYoungestRecord(tabRental.colLastUpdate());
        Customer lastlyCreatedCustomerRental = findTheYoungestRecord(tabCustomer.colCreateDate());
        Payment lastPayment = findTheYoungestRecord(tabPayment.colPaymentDate());
        return null;
    }

    public <E extends Entity, F extends Date> E findTheYoungestRecord(Column<E, LocalDateTime, ?> column) {
        return db.select(column.getInstance())
                .orderDescBy(column)
                .findOne();
    }


}
