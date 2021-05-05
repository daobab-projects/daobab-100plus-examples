package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Remote Select Many Cells
 * ---------------------------------------------------------
 * - How to select many cells remotely
 */
@Component
public class E079_Remote_Select_Many_Cells extends ServiceBase<List<String>> {


    @Override
    public List<String> call() {
        var t = tabFilm;
        return remote.select(t.colTitle())
                .whereLess(t.colID(), 30)
                .orderDescBy(t.colTitle())
                .findMany();
    }


}
