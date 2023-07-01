package io.daobab.demo.dao.table;

import io.daobab.creation.DaobabCache;
import io.daobab.demo.dao.column.*;
import io.daobab.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "STAFF")
public class Staff extends Table<Staff> implements
	StaffId<Staff>,
	FirstName<Staff>,
	LastName<Staff>,
	AddressId<Staff>,
	Picture<Staff>,
	Email<Staff>,
	StoreId<Staff>,
	Active<Staff>,
	Username<Staff>,
	Password<Staff>,
	LastUpdate<Staff>,

	PrimaryKey<Staff,Integer,StaffId>
	{

	public Staff() {
		super();
	}

		public Staff(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colStaffId()).primaryKey().size(8),
			new TableColumn(colFirstName()).size(45),
			new TableColumn(colLastName()).size(45),
			new TableColumn(colAddressId()).size(16),
			new TableColumn(colPicture()).size(1000000000),
			new TableColumn(colEmail()).size(50),
			new TableColumn(colStoreId()).size(8),
			new TableColumn(colActive()).size(1),
			new TableColumn(colUsername()).size(16),
			new TableColumn(colPassword()).size(40),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Staff, Integer, StaffId> colID() {
		return colStaffId();
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
