package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.EntityMap;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entity Clone
 * ---------------------------------------------------------
 * - How to use clone entity
 */
@Component
public class E060_Cloning_Entity extends ServiceBase<Void> {


    @Override
    public Void call() {
        var film1 = db.select(tabFilm)
                .whereEqual(tabFilm.colID(), 10)
                .findOne();
        var film2 = film1.clone();

        //make a difference:
        film2.setDescription("this is my change");
        film2.setLastUpdate(null);

        checkClone(film1, film2);
        return null;

    }

    private void checkClone(EntityMap source, EntityMap clone) {
        log.info("Entity " + source.getEntityName() + " has " + source.keySet().size() + " fields.");
        for (var k : source.keySet()) {
            var objsrc = source.get(k);
            var objcln = clone.get(k);
            if (objsrc == null && objcln == null) continue;
            if (objsrc == null && objcln == null == false) {
                log.warn("clone has no field " + k);
            }
            if (objsrc.equals(objcln) == false) {
                log.warn("clone has different value of field " + k);
            }
        }

    }


}
