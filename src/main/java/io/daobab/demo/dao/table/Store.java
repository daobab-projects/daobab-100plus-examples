package io.daobab.demo.dao.table;

import io.daobab.creation.DaobabCache;
import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.demo.dao.column.ManagerStaffId;
import io.daobab.demo.dao.column.StoreId;
import io.daobab.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "STORE")
public class Store extends Table<Store> implements
	StoreId<Store>,
	ManagerStaffId<Store>,
	AddressId<Store>,
	LastUpdate<Store>,

	PrimaryKey<Store,Integer,StoreId>
	{

	public Store() {
		super();
	}

		public Store(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colStoreId()).primaryKey().size(8),
			new TableColumn(colManagerStaffId()).size(8),
			new TableColumn(colAddressId()).size(16),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Store, Integer, StoreId> colID() {
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
