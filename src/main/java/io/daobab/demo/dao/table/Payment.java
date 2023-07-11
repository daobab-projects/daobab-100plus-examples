package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.*;
import io.daobab.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableInformation(name = "PAYMENT")
public class Payment extends Table<Payment> implements
        PaymentId<Payment, Integer>,
        CustomerId<Payment, Integer>,
        StaffId<Payment, Integer>,
        RentalId<Payment, BigDecimal>,
        Amount<Payment, BigDecimal>,
        PaymentDate<Payment, LocalDateTime>,
        LastUpdate<Payment, LocalDateTime>,

        PrimaryKey<Payment, Integer, PaymentId> {

    public Payment() {
        super();
    }

    public Payment(Map<String, Object> parameters) {
        super(parameters);
    }


    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colPaymentId()).primaryKey().size(16),
                new TableColumn(colCustomerId()).size(16),
                new TableColumn(colStaffId()).size(8),
                new TableColumn(colRentalId()).size(32),
                new TableColumn(colAmount()).size(5).scale(2),
                new TableColumn(colPaymentDate()).size(26).scale(6),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Payment, Integer, PaymentId> colID() {
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
