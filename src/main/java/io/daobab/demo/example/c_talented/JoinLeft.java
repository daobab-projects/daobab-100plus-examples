package io.daobab.demo.example.c_talented;

import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.daobab.statement.join.JoinType.LEFT_JOIN;


/**
 * ---------------------------------------------------------
 * Join Left
 * ---------------------------------------------------------
 * - How to use LEFT_JOIN or other join types
 */
@Component
public class JoinLeft extends ServiceBase<List<FlatPlate>> {

    @Override
    public List<FlatPlate> call() {
        var rv = way01();
        rv.forEach(r -> log.info(r.toString()));
        return rv;
    }


    public List<FlatPlate> way01() {
        var c = tabCustomer;
        var a = tabAddress;
        return db.select(c.colFirstName(), c.colLastName(), a.colPhone())
                .join(LEFT_JOIN, a, c.colAddressId())
                .flat()
                .findMany();
    }


}
