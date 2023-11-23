package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.RentalId;
import io.daobab.demo.dao.column.RentalDate;
import io.daobab.demo.dao.column.InventoryId;
import io.daobab.demo.dao.column.CustomerId;
import io.daobab.demo.dao.column.ReturnDate;
import io.daobab.demo.dao.column.StaffId;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "RENTAL")
public class Rental extends Table<Rental> implements
	RentalId<Rental>,
	RentalDate<Rental>,
	InventoryId<Rental>,
	CustomerId<Rental>,
	ReturnDate<Rental>,
	StaffId<Rental>,
	LastUpdate<Rental>,

	PrimaryKey<Rental,BigDecimal,RentalId>
	{

	public Rental() {
		super();
	}

	Rental(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colRentalId()).primaryKey().size(32),
			new TableColumn(colRentalDate()).size(26).scale(6),
			new TableColumn(colInventoryId()).size(32),
			new TableColumn(colCustomerId()).size(16),
			new TableColumn(colReturnDate()).size(26).scale(6),
			new TableColumn(colStaffId()).size(8),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Rental, BigDecimal, RentalId> colID() {
		return colRentalId();
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
