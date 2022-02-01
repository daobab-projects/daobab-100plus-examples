package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.model.PrimaryKey;
import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.dao.column.Address2;
import io.daobab.demo.dao.column.District;
import io.daobab.demo.dao.column.CityId;
import io.daobab.demo.dao.column.PostalCode;
import io.daobab.demo.dao.column.Phone;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.model.Table;

import java.lang.Integer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Address extends Table implements 
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

	@Override
	public String getEntityName() {
		return "ADDRESS";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
			new TableColumn(colAddressId()).primaryKey().size(5),
			new TableColumn(colAddress()).size(50),
			new TableColumn(colAddress2()).size(50),
			new TableColumn(colDistrict()).size(20),
			new TableColumn(colCityId()).size(5),
			new TableColumn(colPostalCode()).size(10),
			new TableColumn(colPhone()).size(20),
			new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public Address clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Address,Integer,AddressId> colID() {
		return colAddressId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		PrimaryKey<?,?,?> other = (PrimaryKey<?,?,?>) obj;
		return Objects.equals(getId(), other.getId());
	}




}
