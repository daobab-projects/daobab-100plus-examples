package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Plate;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Plate
 * ---------------------------------------------------------
 * - How to select Plate remotely
 */
@Component
public class RemotePlate extends ServiceBase<Plate> {


    @Override
    public Plate call() {
        var t = tabFilm;
        return remote.select(t.colTitle(), t.colDescription())
                .whereLess(t.colID(), 10)
                .findOne();
    }


}
