package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.model.PrimaryKey;
import io.daobab.demo.dao.column.PaymentId;
import io.daobab.demo.dao.column.CustomerId;
import io.daobab.demo.dao.column.StaffId;
import io.daobab.demo.dao.column.RentalId;
import io.daobab.demo.dao.column.Amount;
import io.daobab.demo.dao.column.PaymentDate;
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
public class Payment extends Table implements 
	PaymentId<Payment>,
	CustomerId<Payment>,
	StaffId<Payment>,
	RentalId<Payment>,
	Amount<Payment>,
	PaymentDate<Payment>,
	LastUpdate<Payment>,

	PrimaryKey<Payment,Integer,PaymentId>
	{

	@Override
	public String getEntityName() {
		return "PAYMENT";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
			new TableColumn(colPaymentId()).primaryKey().size(5),
			new TableColumn(colCustomerId()).size(5),
			new TableColumn(colStaffId()).size(3),
			new TableColumn(colRentalId()).size(10),
			new TableColumn(colAmount()).size(5).scale(2),
			new TableColumn(colPaymentDate()).size(26).scale(6),
			new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public Payment clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Payment,Integer,PaymentId> colID() {
		return colPaymentId();
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
