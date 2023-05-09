package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface PaymentId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getPaymentId() {
        return getColumnParam("PaymentId");
    }

    @SuppressWarnings("unchecked")
    default E setPaymentId(F val) {
        setColumnParam("PaymentId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:PAYMENT,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, PaymentId> colPaymentId() {
        return new Column<E, F, PaymentId>() {

            @Override
            public String getColumnName() {
                return "PAYMENT_ID";
            }

            @Override
            public String getFieldName() {
                return "PaymentId";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return Integer.class;
            }

            @Override
            public F getValue(PaymentId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "PaymentId");
                return (F) entity.getPaymentId();
            }

            @Override
            public void setValue(PaymentId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "PaymentId");
                entity.setPaymentId(param);
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
