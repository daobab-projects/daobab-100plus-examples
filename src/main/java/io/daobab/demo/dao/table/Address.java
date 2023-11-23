package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.dao.column.Address2;
import io.daobab.demo.dao.column.District;
import io.daobab.demo.dao.column.CityId;
import io.daobab.demo.dao.column.PostalCode;
import io.daobab.demo.dao.column.Phone;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "ADDRESS")
public class Address extends Table<Address> implements
	AddressId<Address>,
	io.daobab.demo.dao.column.Address<Address>,
	Address2<Address>,
	District<Address>,
	CityId<Address>,
	PostalCode<Address>,
	Phone<Address>,
	LastUpdate<Address>,

	PrimaryKey<Address,Integer,AddressId>
	{

	public Address() {
		super();
	}

	Address(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colAddressId()).primaryKey().size(16),
			new TableColumn(colAddress()).size(50),
			new TableColumn(colAddress2()).size(50),
			new TableColumn(colDistrict()).size(20),
			new TableColumn(colCityId()).size(16),
			new TableColumn(colPostalCode()).size(10),
			new TableColumn(colPhone()).size(20),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Address, Integer, AddressId> colID() {
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
