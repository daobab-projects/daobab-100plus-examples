package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Conditinal Where
 * ---------------------------------------------------------
 * - How to use Conditional Where
 */
@Component
public class E080_Conditional_Where extends ServiceBase<List<String>> {


    @Override
    public List<String> call() {
        return way01(true, true);
    }

    public List<String> way01(boolean byLength, boolean byLanguage) {
        var t = tabFilm;
        return db.select(t.colTitle())
                .where(and()
                        .ifTrue(byLength, w -> w.greater(t.colLength(), 100))
                        .ifTrue(byLanguage, w -> w.equal(t.colLanguageId(), 1)))
                .orderDescBy(t.colTitle())
                .limitBy(20)
                .findMany();
    }


}
