package io.daobab.demo.example.part_d;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import org.springframework.boot.SpringApplication;
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
public class ConditionIfNotNull extends ServiceBase<List<String>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ConditionIfNotNull.class.getName());
    }

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
