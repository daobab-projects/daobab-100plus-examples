package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Plates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Plates
 * ---------------------------------------------------------
 * - How to select Plates remotely
 */
@Component
public class RemoteSelectManyColumns extends ServiceBase<Plates> {


    @Override
    public Plates call() {
        var t = tabFilm;
        return remote.select(t.colTitle(), t.colDescription())
                .whereLess(t.colID(), 30)
                .orderDescBy(t.colTitle())
                .findMany();
    }


}
