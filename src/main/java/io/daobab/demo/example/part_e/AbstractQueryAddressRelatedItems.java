package io.daobab.demo.example.part_e;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.column.AddressId;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Abstract Query Address Related Items
 * ---------------------------------------------------------
 * - How to build abstract query to apply specified type of Entities only
 */
@Component
public class AbstractQueryAddressRelatedItems extends ServiceBase<Void> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, AbstractQueryAddressRelatedItems.class.getName());
    }


    @Override
    public Void call() {
        var adress = db.findOneByPk(tabAddress, 1);

        var customers = findAddressRelated(tabCustomer, adress);
        var stores = findAddressRelated(tabStore, adress);
        var staff = findAddressRelated(tabStaff, adress);

        return null;
    }

    public <V extends Entity, E extends Entity & AddressId<E, Integer>> Entities<E> findAddressRelated(E entity, AddressId<V, Integer> addressId) {
        return db.select(entity)
                .whereEqual(entity.colAddressId(), addressId.getAddressId())
                .findMany();
    }


}
