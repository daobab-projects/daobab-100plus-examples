package io.daobab.demo.model;

import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.dao.table.Payment;
import io.daobab.model.TableInformation;

import java.util.Map;

public class ActorLazyLoading extends FilmActor implements ActorLazy<FilmActor>{

    public ActorLazyLoading(FilmActor filmActor){

        merge(filmActor);
    }

    public ActorLazyLoading() {
        super();
    }

    public ActorLazyLoading(Map<String, Object> parameters) {
        super(parameters);
    }

}
