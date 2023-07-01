package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface PaymentId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getPaymentId() {
        return readParam("PaymentId");
    }

    default E setPaymentId(F val) {
        return storeParam("PaymentId", val);
    }

    /**
     * table:PAYMENT,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, PaymentId> colPaymentId() {
        return ColumnCache.INSTANCE.getColumn("PaymentId", "PAYMENT_ID", (Table<?>) this, Integer.class);
    }

//
//    @SuppressWarnings("rawtypes")
//    /**
//     * table:PAYMENT,type:SMALLINT,size:16,nullable:false
//     */
//    default Column<E, F, PaymentId> colPaymentId() {
//        return new Column<E, F, PaymentId>() {
//
//            @Override
//            public String getColumnName() {
//                return "PAYMENT_ID";
//            }
//
//            @Override
//            public String getFieldName() {
//                return "PaymentId";
//            }
//
//            @Override
//            public E getInstance(){
//                return getEntity();
//            }
//
//            @Override
//            public Class getFieldClass() {
//                return Integer.class;
//            }
//
//            @Override
//            public F getValue(PaymentId entity) {
//                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "PaymentId");
//                return (F) entity.getPaymentId();
//            }
//
//            @Override
//            public PaymentId setValue(PaymentId entity, F param) {
//                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "PaymentId");
//                return (PaymentId) entity.setPaymentId(param);
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
