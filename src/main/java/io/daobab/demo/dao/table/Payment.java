package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.PaymentId;
import io.daobab.demo.dao.column.CustomerId;
import io.daobab.demo.dao.column.StaffId;
import io.daobab.demo.dao.column.RentalId;
import io.daobab.demo.dao.column.Amount;
import io.daobab.demo.dao.column.PaymentDate;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "PAYMENT")
public class Payment extends Table<Payment> implements
	PaymentId<Payment>,
	CustomerId<Payment>,
	StaffId<Payment>,
	RentalId<Payment>,
	Amount<Payment>,
	PaymentDate<Payment>,
	LastUpdate<Payment>,

	PrimaryKey<Payment,Integer,PaymentId>
	{

	public Payment() {
		super();
	}

	Payment(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colPaymentId()).primaryKey().size(16),
			new TableColumn(colCustomerId()).size(16),
			new TableColumn(colStaffId()).size(8),
			new TableColumn(colRentalId()).size(32),
			new TableColumn(colAmount()).size(5).scale(2),
			new TableColumn(colPaymentDate()).size(26).scale(6),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Payment, Integer, PaymentId> colID() {
		return colPaymentId();
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
