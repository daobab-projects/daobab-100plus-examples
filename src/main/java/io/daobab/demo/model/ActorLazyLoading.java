package io.daobab.demo.model;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.dao.table.Payment;

public class ActorLazyLoading extends FilmActor implements ActorLazy<FilmActor>{

    public ActorLazyLoading(FilmActor filmActor){
        putAll(filmActor);
    }

}
