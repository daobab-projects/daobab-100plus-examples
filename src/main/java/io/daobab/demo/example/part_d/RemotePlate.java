package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.Plate;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Plate
 * ---------------------------------------------------------
 * - How to select Plate remotely
 */
@Component
public class RemotePlate extends ServiceBase<Plate> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemotePlate.class.getName());
    }

    @Override
    public Plate call() {
        var t = tabFilm;
        return remote.select(t.colTitle(), t.colDescription())
                .whereLess(t.colID(), 10)
                .findOne();
    }


}
