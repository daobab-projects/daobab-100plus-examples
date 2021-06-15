package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.target.meta.MetaDataTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * ByteBuffer
 * ---------------------------------------------------------
 */
@Component
public class ByteBuffer extends ServiceBase<Void> implements MetaDataTables {


    @Override
    public Void call() {

        var bb=db.select(tabFilm).createByteBuffer();


        bb.select(tabFilm).whereLess(tabFilm.colFilmId(),4).forEach(c->log.info(c.toJSON()));
        db.select(tabFilm).whereLess(tabFilm.colFilmId(),4).forEach(c->log.info(c.toJSON()));

        return null;
    }




}
