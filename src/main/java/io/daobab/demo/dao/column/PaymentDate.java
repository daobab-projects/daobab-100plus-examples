package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.time.LocalDateTime;
import java.util.Objects;

public interface PaymentDate<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getPaymentDate() {
        return getColumnParam("PaymentDate");
    }

    @SuppressWarnings("unchecked")
    default E setPaymentDate(F val) {
        setColumnParam("PaymentDate", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:PAYMENT,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, PaymentDate> colPaymentDate() {
        return new Column<E, F, PaymentDate>() {

            @Override
            public String getColumnName() {
                return "PAYMENT_DATE";
            }

            @Override
            public String getFieldName() {
                return "PaymentDate";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return LocalDateTime.class;
            }

            @Override
            public F getValue(PaymentDate entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "PaymentDate");
                return (F) entity.getPaymentDate();
            }

            @Override
            public void setValue(PaymentDate entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "PaymentDate");
                entity.setPaymentDate(param);
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }

            @Override
            public String toString(){
                return getEntityName()+"."+getFieldName();
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)return true;
                if (obj == null)return false;
                if (getClass() != obj.getClass())return false;
                Column other = (Column) obj;
                return Objects.equals(hashCode(), other.hashCode());
            }
        };
    }

}
