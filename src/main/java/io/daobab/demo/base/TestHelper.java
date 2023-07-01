package io.daobab.demo.base;

import io.daobab.model.Entity;
import io.daobab.model.Plate;
import io.daobab.model.PrimaryKey;
import io.daobab.result.FlatPlates;
import io.daobab.target.buffer.single.Entities;
import io.daobab.target.buffer.single.Plates;
import org.slf4j.Logger;

import java.util.List;

public interface TestHelper {


    Logger getLog();


    default <E extends Entity & PrimaryKey> void validation(E entity) {
        check(entity);
        getLog().info("Result: entity " + entity.entityClass().getName());
        getLog().info(entity.toJson());
    }

    default <E extends Entity & PrimaryKey> void validation(Entities<E> entity) {
        check(entity);
        getLog().info(entity.toJson());
    }


    default void validation(Plate entity) {
        check(entity);
        getLog().info(entity.toJson());
    }

    default void validation(Plates entity) {
        check(entity);
        getLog().info(entity.toJson());
    }


    default void validation(FlatPlates entity) {
        check(entity);
        getLog().info(entity.toJson());
    }

    default <F> void validation(List<F> entity) {
        check(entity);
        entity.forEach(System.out::println);
    }

    default <F> void validation(F entity) {
        check(entity);
        getLog().info(entity.toString());
    }

    default <F> void validation(Void entity) {
//        check(entity);
        getLog().info("result: expected null");
    }

    default void check(Object obj) {

    }

}
