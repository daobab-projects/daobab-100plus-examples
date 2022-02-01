package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.FlatPlate;
import org.springframework.boot.SpringApplication;
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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, JoinLeft.class.getName());
    }


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
