package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.model.PrimaryKey;
import io.daobab.demo.dao.column.StaffId;
import io.daobab.demo.dao.column.FirstName;
import io.daobab.demo.dao.column.LastName;
import io.daobab.demo.dao.column.AddressId;
import io.daobab.demo.dao.column.Picture;
import io.daobab.demo.dao.column.Email;
import io.daobab.demo.dao.column.StoreId;
import io.daobab.demo.dao.column.Active;
import io.daobab.demo.dao.column.Username;
import io.daobab.demo.dao.column.Password;
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
public class Staff extends Table implements 
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

	@Override
	public String getEntityName() {
		return "STAFF";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
			new TableColumn(colStaffId()).primaryKey().size(3),
			new TableColumn(colFirstName()).size(45),
			new TableColumn(colLastName()).size(45),
			new TableColumn(colAddressId()).size(5),
			new TableColumn(colPicture()).lob(),
			new TableColumn(colEmail()).size(50),
			new TableColumn(colStoreId()).size(3),
			new TableColumn(colActive()).size(1),
			new TableColumn(colUsername()).size(16),
			new TableColumn(colPassword()).size(40),
			new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public Staff clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Staff,Integer,StaffId> colID() {
		return colStaffId();
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
