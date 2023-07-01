package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.*;
import io.daobab.model.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableName(value = "ADDRESS")
public class Address extends Table<Address> implements
        AddressId<Address, Integer>,
        io.daobab.demo.dao.column.Address<Address, String>,
        Address2<Address, String>,
        District<Address, String>,
        CityId<Address, Integer>,
        PostalCode<Address, String>,
        Phone<Address, String>,
        LastUpdate<Address, LocalDateTime>,

        PrimaryKey<Address, Integer, AddressId> {


    public Address() {
        super();
    }

    public Address(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colAddressId()).primaryKey().size(16),
                new TableColumn(colAddress()).size(50),
                new TableColumn(colAddress2()).size(50),
                new TableColumn(colDistrict()).size(20),
                new TableColumn(colCityId()).size(16),
                new TableColumn(colPostalCode()).size(10),
                new TableColumn(colPhone()).size(20),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Address, Integer, AddressId> colID() {
        return colAddressId();
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
