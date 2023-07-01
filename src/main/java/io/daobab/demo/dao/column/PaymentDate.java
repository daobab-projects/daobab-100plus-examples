package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.time.LocalDateTime;

public interface PaymentDate<E extends Entity, F> extends EntityRelationMap<E> {


    default F getPaymentDate() {
        return readParam("PaymentDate");
    }

    default E setPaymentDate(F val) {
        return storeParam("PaymentDate", val);
    }

    @SuppressWarnings("unchecked")
    /**
     * table:PAYMENT,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, PaymentDate> colPaymentDate() {
        return ColumnCache.INSTANCE.getColumn("PaymentDate","PAYMENT_DATE",(Table<?>)this,LocalDateTime.class);
    }

//
//    @SuppressWarnings("rawtypes")
//
//    default Column<E, F, PaymentDate> colPaymentDate() {
//        return new Column<E, F, PaymentDate>() {
//
//            @Override
//            public String getColumnName() {
//                return "PAYMENT_DATE";
//            }
//
//            @Override
//            public String getFieldName() {
//                return "PaymentDate";
//            }
//
//            @Override
//            public E getInstance(){
//                return getEntity();
//            }
//
//            @Override
//            public Class getFieldClass() {
//                return LocalDateTime.class;
//            }
//
//            @Override
//            public F getValue(PaymentDate entity) {
//                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "PaymentDate");
//                return (F) entity.getPaymentDate();
//            }
//
//            @Override
//            public PaymentDate setValue(PaymentDate entity, F param) {
//                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "PaymentDate");
//                return (PaymentDate) entity.setPaymentDate(param);
//            }
//
//            @Override
//            public int hashCode() {
//                return toString().hashCode();
//            }
//
//            @Override
//            public String toString(){
//                return getEntityClass().getName()+"."+getFieldName();
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                if (this == obj)return true;
//                if (obj == null)return false;
//                if (getClass() != obj.getClass())return false;
//                Column other = (Column) obj;
//                return Objects.equals(hashCode(), other.hashCode());
//            }
//        };
//    }

}
