package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Remote Security - Forbidden Columns
 * ---------------------------------------------------------
 * - How to prevent from select some columns
 */
@Component
public class RemoteSecurityForbiddenColumns extends ServiceBase<List<Customer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemoteSecurityForbiddenColumns.class.getName());
    }

    @Override
    public List<Customer> call() {
        var t = tabCustomer;
        return remote.select(t)
                .whereLess(t.colAddressId(), 10)
                .findMany();
    }


}
