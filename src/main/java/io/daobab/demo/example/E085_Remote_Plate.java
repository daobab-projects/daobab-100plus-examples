package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Plate
 * ---------------------------------------------------------
 * - How to select Plate remotely
 */
@Component
public class E085_Remote_Plate extends ServiceBase<Plate> {


    @Override
    public Plate call() {
        var t = tabFilm;
        return remote.select(t.colTitle(), t.colDescription())
                .whereLess(t.colID(), 10)
                .findOne();
    }


}
