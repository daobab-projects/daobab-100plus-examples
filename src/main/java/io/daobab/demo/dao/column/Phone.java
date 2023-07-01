package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



public interface Phone<E extends Entity, F> extends EntityRelationMap<E> {


    default F getPhone() {
        return readParam("Phone");
    }

    default E setPhone(F val) {
        return storeParam("Phone", val);
    }

    /**
     * table:ADDRESS,type:VARCHAR,size:20,nullable:false
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, Phone> colPhone() {
        return ColumnCache.INSTANCE.getColumn("Phone","PHONE",(Table<?>)this,String.class);
    }
//
//    @SuppressWarnings("rawtypes")
//
//    default Column<E, F, Phone> colPhone() {
//        return new Column<E, F, Phone>() {
//
//            @Override
//            public String getColumnName() {
//                return "PHONE";
//            }
//
//            @Override
//            public String getFieldName() {
//                return "Phone";
//            }
//
//            @Override
//            public E getInstance(){
//                return getEntity();
//            }
//
//            @Override
//            public Class getFieldClass() {
//                return String.class;
//            }
//
//            @Override
//            public F getValue(Phone entity) {
//                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Phone");
//                return (F) entity.getPhone();
//            }
//
//            @Override
//            public Phone setValue(Phone entity, F param) {
//                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Phone");
//                return (Phone) entity.setPhone(param);
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
