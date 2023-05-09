package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Staff;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Get Entities but without certain columns - by skipping some columns
 * ---------------------------------------------------------
 * Warning: PK cannot be skipped if the entity has it.
 */
@Component
public class SelectPartialEntityBySkip extends ServiceBase<Entities<Staff>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectPartialEntityBySkip.class.getName());
    }

    @Override
    public Entities<Staff> call() {
        return db.select(tabStaff)
                .skip(tabStaff.colPicture(),tabStaff.colPassword())
                .findMany();
    }

}
