package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use a blob
 * ---------------------------------------------------------
 */
@Component
public class SelectBlob extends ServiceBase<byte[]> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectBlob.class.getName());
    }

    @Override
    public byte[] call() {
        return db.select(tabStaff.colPicture())
                .whereEqual(tabStaff.colID(), 1)
                .findOne();
    }

}
