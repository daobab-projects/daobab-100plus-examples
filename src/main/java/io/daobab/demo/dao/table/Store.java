package io.daobab.demo.dao.table;


import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.demo.dao.column.ManagerStaffId;
import io.daobab.demo.dao.column.StoreId;
import io.daobab.model.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableName(value="STORE")
public class Store extends Table<Store> implements
        StoreId<Store, Integer>,
        ManagerStaffId<Store, Integer>,
        AddressId<Store, Integer>,
        LastUpdate<Store, LocalDateTime>,

        PrimaryKey<Store, Integer, StoreId> {


    public Store() {
        super();
    }

    public Store(Map<String, Object> parameters) {
        super(parameters);
    }


    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colStoreId()).primaryKey().size(8),
                new TableColumn(colManagerStaffId()).size(8),
                new TableColumn(colAddressId()).size(16),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Store, Integer, StoreId> colID() {
        return colStoreId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PrimaryKey<?, ?, ?> other = (PrimaryKey<?, ?, ?>) obj;
        return Objects.equals(getId(), other.getId());
    }


}
