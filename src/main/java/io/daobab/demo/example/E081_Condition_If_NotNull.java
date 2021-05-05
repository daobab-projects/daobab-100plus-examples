package io.daobab.demo.example;

import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.condition.Operator.EQ;

/**
 * ---------------------------------------------------------
 * Condition If Not Null
 * ---------------------------------------------------------
 * - How to use Conditional Where If Not Null
 */
@Component
public class E081_Condition_If_NotNull extends ServiceBase<List<String>> {


    @Override
    public List<String> call() {
        var t = tabFilm;
        return db.select(t.colTitle())
                .where(and()
                        .ifNotNull(t.colLanguageId(), EQ, 1))
                .orderDescBy(t.colTitle())
                .limitBy(20)
                .findMany();
    }


}
