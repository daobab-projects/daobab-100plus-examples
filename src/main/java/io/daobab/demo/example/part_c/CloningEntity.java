package io.daobab.demo.example.part_c;

import io.daobab.creation.EntityCreator;
import io.daobab.converter.duplicator.duplication.EntityDuplication;
import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Entity Clone
 * ---------------------------------------------------------
 */
@Component
public class CloningEntity extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, CloningEntity.class.getName());
    }

    @Override
    public Void call() {
        var film1 = db.select(tabFilm)
                .whereEqual(tabFilm.colID(), 10)
                .findOne();
        var film2 = EntityCreator.cloneEntity(film1);

        //make a difference:
        film2.setDescription("this is my change");
        film2.setLastUpdate(null);

        checkClone(film1, film2);
        return null;

    }

    private void checkClone(Entity source, Entity clone) {
//        log.info("Entity " + source.getEntityName() + " has " + source.keySet().size() + " fields.");
//        for (var k : source.keySet()) {
//            var objsrc = source.get(k);
//            var objcln = clone.get(k);
//            if (objsrc == null && objcln == null) continue;
//            if (objsrc == null && objcln == null == false) {
//                log.warn("clone has no field " + k);
//            }
//            if (objsrc.equals(objcln) == false) {
//                log.warn("clone has different value of field " + k);
//            }
//        }

    }


}
