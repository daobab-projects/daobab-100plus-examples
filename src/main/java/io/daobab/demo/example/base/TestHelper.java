package io.daobab.demo.example.base;

import io.daobab.model.EntityMap;
import io.daobab.model.Plate;
import io.daobab.model.PrimaryKey;
import io.daobab.result.Entities;
import io.daobab.result.FlatPlates;
import io.daobab.result.Plates;
import org.slf4j.Logger;

import java.util.List;

public interface TestHelper {


    Logger getLog();


    default <E extends EntityMap & PrimaryKey> void validation(E entity) {
        check(entity);
        getLog().info("Result: entity " + entity.getEntityName());
        getLog().info(entity.toJSON());
    }

    default <E extends EntityMap & PrimaryKey> void validation(Entities<E> entity) {
        check(entity);
        getLog().info(entity.toJSON());
    }


    default void validation(Plate entity) {
        check(entity);
        System.out.println(entity.toJSON());
    }

    default void validation(Plates entity) {
        check(entity);
        System.out.println(entity.toJSON());
    }


    default void validation(FlatPlates entity) {
        check(entity);
        System.out.println(entity.toJSON());
    }

    default <F> void validation(List<F> entity) {
        check(entity);
        entity.forEach(System.out::println);
    }

    default <F> void validation(F entity) {
        check(entity);
        System.out.println(entity);
    }

    default <F> void validation(Void entity) {
//        check(entity);
        getLog().info("result: expected null");
    }

    default void check(Object obj) {

    }

}
