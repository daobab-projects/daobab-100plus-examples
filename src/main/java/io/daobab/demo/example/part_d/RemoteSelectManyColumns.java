package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.target.buffer.single.Plates;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Plates
 * ---------------------------------------------------------
 * - How to select Plates remotely
 */
@Component
public class RemoteSelectManyColumns extends ServiceBase<Plates> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemoteSelectManyColumns.class.getName());
    }

    @Override
    public Plates call() {
        var t = tabFilm;
        return remote.select(t.colTitle(), t.colDescription())
                .whereLess(t.colID(), 30)
                .orderDescBy(t.colTitle())
                .findMany();
    }


}
