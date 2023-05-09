package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.demo.dao.column.ManagerStaffId;
import io.daobab.demo.dao.column.StoreId;
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
public class Store extends Table implements
        StoreId<Store, Integer>,
        ManagerStaffId<Store, Integer>,
        AddressId<Store, Integer>,
        LastUpdate<Store, LocalDateTime>,

        PrimaryKey<Store, Integer, StoreId>
	{

	@Override
	public String getEntityName() {
		return "STORE";
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
	public Store clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Store,Integer,StoreId> colID() {
		return colStoreId();
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
