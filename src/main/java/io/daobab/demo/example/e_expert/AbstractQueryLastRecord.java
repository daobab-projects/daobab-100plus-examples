package io.daobab.demo.example.e_expert;

import io.daobab.demo.dao.table.*;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ---------------------------------------------------------
 * Abstract query
 * ---------------------------------------------------------
 * - How to use abstract queries
 */
@Component
public class AbstractQueryLastRecord extends ServiceBase<Void> {


    @Override
    public Void call() {
        Film lastRecordFilm = findTheYougestRecord(tabFilm.colLastUpdate());
        Actor lastRecordActor = findTheYougestRecord(tabActor.colLastUpdate());
        Rental lastRecordRental = findTheYougestRecord(tabRental.colLastUpdate());
        Customer lastlyCreatedCustomerRental = findTheYougestRecord(tabCustomer.colCreateDate());
        Payment lastPayment = findTheYougestRecord(tabPayment.colPaymentDate());
        return null;
    }

    public <E extends Entity, F extends Date> E findTheYougestRecord(Column<E, F, ?> column) {
        return db.select(column.getInstance())
                .orderDescBy(column)
                .findOne();
    }


}
