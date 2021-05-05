package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Blob
 * ---------------------------------------------------------
 * - How to read blob table
 */
@Component
public class E045_Blob extends ServiceBase<byte[]> {

    @Override
    public byte[] call() {
        return db.select(tabStaff.colPicture())
                .whereEqual(tabStaff.colID(), 1)
                .findOne();
    }

}
