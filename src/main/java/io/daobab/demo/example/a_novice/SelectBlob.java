package io.daobab.demo.example.a_novice;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use a blob
 * ---------------------------------------------------------
 */
@Component
public class SelectBlob extends ServiceBase<byte[]> {

    @Override
    public byte[] call() {
        return db.select(tabStaff.colPicture())
                .whereEqual(tabStaff.colID(), 1)
                .findOne();
    }

}
