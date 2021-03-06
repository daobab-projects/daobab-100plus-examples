package io.daobab.demo.example.d_proficient;

import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Conditional Where
 * ---------------------------------------------------------
 */
@Component
public class ConditionalWhere extends ServiceBase<List<String>> {


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
