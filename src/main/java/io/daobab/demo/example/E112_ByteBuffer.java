package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.EntityByteBuffer;
import io.daobab.target.meta.MetaSpecificsTables;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Protection against accidental delete
 * ---------------------------------------------------------
 * Daobab requires a where clause for each delete and update
 */
@Component
public class E112_ByteBuffer extends ServiceBase<Void> implements MetaSpecificsTables {


    @Override
    public Void call() {

        var bb=db.select(tabFilm).createByteBuffer();


        bb.select(tabFilm).whereLess(tabFilm.colFilmId(),4).forEach(c->log.info(c.toJSON()));
        db.select(tabFilm).whereLess(tabFilm.colFilmId(),4).forEach(c->log.info(c.toJSON()));

        return null;
    }




}
