package io.daobab.demo.example.e_expert;

import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.base.ServiceBase;
import io.daobab.model.EntityMap;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Abstract Query Address Related Items
 * ---------------------------------------------------------
 * - How to build abstract query to apply specified type of Entities only
 */
@Component
public class AbstractQueryAddressRelatedItems extends ServiceBase<Void> {


    @Override
    public Void call() {
        var adress = db.findOneByPk(tabAddress, 1);

        var customers = findAddressRelated(tabCustomer, adress);
        var stores = findAddressRelated(tabStore, adress);
        var staff = findAddressRelated(tabStaff, adress);

        return null;
    }

    public <V extends EntityMap, E extends EntityMap & AddressId<E>> Entities<E> findAddressRelated(E entity, AddressId<V> addressId) {
        return db.select(entity)
                .whereEqual(entity.colAddressId(), addressId.getAddressId())
                .findMany();
    }


}
