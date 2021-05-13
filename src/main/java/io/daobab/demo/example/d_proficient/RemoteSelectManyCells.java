package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
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


    @Override
    public List<String> call() {
        var t = tabFilm;
        return remote.select(t.colTitle())
                .whereLess(t.colID(), 30)
                .orderDescBy(t.colTitle())
                .findMany();
    }


}
