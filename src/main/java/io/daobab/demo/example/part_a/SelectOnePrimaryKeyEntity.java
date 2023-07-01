package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ExampleTag;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.dao.table.FilmActor;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import static io.daobab.demo.base.Tag.SELECT;

/**
 * ---------------------------------------------------------
 * Get entity by PrimaryKey ID
 * ---------------------------------------------------------
 * - How to get an entity having PK value
 * - How to get an entity having FK related entity object
 * - How to get an entity through related entity method
 * <p>
 * Daobab attach universal ID column to every Primary Key entity,
 * whatever Entity contains such column or not.
 */
@Component
public class SelectOnePrimaryKeyEntity extends ServiceBase<Actor> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, SelectOnePrimaryKeyEntity.class.getName());
    }

    @Override
    public Actor call() {
        return scenario01();
    }

    @ExampleTag(SELECT)
    //Classic usage
    public Actor scenario01() {
        return db.select(tabActor)
                .whereEqual(tabActor.colID(), 1)
                .findOne();
    }


    //Using reference for shorter query
    public Actor scenario02() {
        var t = tabActor;
        return db.select(t)
                .whereEqual(t.colID(), 1)
                .findOne();
    }


    //Quick select by pointing target,table and id value
    public Actor scenario03() {
        return db.findOneByPk(tabActor, 1);
    }


    //Using related Entity as ID carrier
    public Actor scenario04() {
        var relatedEntity = new FilmActor();
        relatedEntity.setActorId(1);
        return db.select(tabActor)
                .whereEqual(tabActor.colID(), relatedEntity)
                .findOne();
    }

}
