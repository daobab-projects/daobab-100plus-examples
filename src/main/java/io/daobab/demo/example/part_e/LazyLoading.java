package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Actor;
import io.daobab.demo.dao.table.FilmActor;
import io.daobab.demo.model.ActorLazyLoading;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Lazy Loading
 * ---------------------------------------------------------
 */
@Component
public class LazyLoading extends ServiceBase<List<ActorLazyLoading>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, LazyLoading.class.getName());
    }

    @Override
    public List<ActorLazyLoading> call() {
        var rv= db.select(tabFilmActor)
                .limitBy(3)
                .map(this::resultCompleter)
                .findMany();

        //pick just one and call a method here to invoke a lazy loading on it
        var picked=rv.get(1);
        log.info(picked.getActor().toJson());
        return rv;

    }

    private ActorLazyLoading resultCompleter(FilmActor filmActor) {
        return new ActorLazyLoading(filmActor) {

            @Override
            public Actor getActor() {
                var rv = super.getActor();
                if (rv == null) {
                   rv=db.select(tabActor).whereEqual(tabActor.colID(),filmActor.getActorId()).findOne();
                   setActor(rv);
                }
                return rv;
            }
        };
    }

}
