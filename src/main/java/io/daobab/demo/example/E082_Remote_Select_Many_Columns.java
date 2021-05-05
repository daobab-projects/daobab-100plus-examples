package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Plates;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Remote Select Plates
 * ---------------------------------------------------------
 * - How to select Plates remotely
 */
@Component
public class E082_Remote_Select_Many_Columns extends ServiceBase<Plates> {


    @Override
    public Plates call() {
        var t = tabFilm;
        return remote.select(t.colTitle(), t.colDescription())
                .whereLess(t.colID(), 30)
                .orderDescBy(t.colTitle())
                .findMany();
    }


}
