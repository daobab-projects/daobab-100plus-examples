package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Remote Select Many Cells
 * ---------------------------------------------------------
 * - How to select many cells remotely
 */
@Component
public class RemoteSelectManyCells extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, RemoteSelectManyCells.class.getName());
    }

    @Override
    public List<String> call() {
        var t = tabFilm;
//        return remote.select(t.colTitle())
//                .whereLess(t.colID(), 30)
//                .orderDescBy(t.colTitle())
//                .findMany();
        return null;
    }


}
