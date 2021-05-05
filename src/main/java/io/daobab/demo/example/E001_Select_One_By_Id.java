package io.daobab.demo.example;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.example.base.ExampleTag;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.demo.example.base.Tag;
import org.springframework.stereotype.Component;

import static io.daobab.demo.example.base.Tag.SELECT;

/**
 * ---------------------------------------------------------
 * Get entity by PrimaryKey ID
 * ---------------------------------------------------------
 * - How to get an entity having PK value
 * - How to get an entity having FK related entity object
 * - How to get an entity through related entity method
 *
 * Daobab attach universal ID column to every Primary Key entity,
 * whatever Entity contains such column or not.
 */
@Component
public class E001_Select_One_By_Id extends ServiceBase<Actor> {


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

    //Using related Entity as ID carrier
    public Actor scenario05() {
        var relatedEntity = new FilmActor();
        relatedEntity.setActorId(1);
        return relatedEntity.findRelatedOne(db, tabActor);
    }
}
