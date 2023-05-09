package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.demo.dao.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;
import io.daobab.model.TableColumn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Customer extends Table implements
		CustomerId<Customer, Integer>,
		StoreId<Customer, Integer>,
		FirstName<Customer, String>,
		LastName<Customer, String>,
		Email<Customer, String>,
		AddressId<Customer, Integer>,
		Active<Customer, Boolean>,
		CreateDate<Customer, LocalDateTime>,
		LastUpdate<Customer, LocalDateTime>,

		PrimaryKey<Customer, Integer, CustomerId>
	{

	@Override
	public String getEntityName() {
		return "CUSTOMER";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
				new TableColumn(colCustomerId()).primaryKey().size(16),
				new TableColumn(colStoreId()).size(8),
				new TableColumn(colFirstName()).size(45),
				new TableColumn(colLastName()).size(45),
				new TableColumn(colEmail()).size(50),
				new TableColumn(colAddressId()).size(16),
				new TableColumn(colActive()).size(1),
				new TableColumn(colCreateDate()).size(26).scale(6),
				new TableColumn(colLastUpdate()).size(26).scale(6)
		);
	}

	@Override
	public Customer clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Customer,Integer,CustomerId> colID() {
		return colCustomerId();
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
