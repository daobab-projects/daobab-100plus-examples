package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



public interface Password<E extends Entity, F> extends EntityRelationMap<E> {


    default F getPassword() {
        return readParam("Password");
    }

    default E setPassword(F val) {
        return storeParam("Password", val);
    }

    /**
     * table:STAFF,type:VARCHAR,size:40,nullable:true
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, Password> colPassword() {
        return ColumnCache.INSTANCE.getColumn("Password","PASSWORD",(Table<?>)this,String.class);
    }
//
//    @SuppressWarnings("rawtypes")
//
//    default Column<E, F, Password> colPassword() {
//        return new Column<E, F, Password>() {
//
//            @Override
//            public String getColumnName() {
//                return "PASSWORD";
//            }
//
//            @Override
//            public String getFieldName() {
//                return "Password";
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
//            public F getValue(Password entity) {
//                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Password");
//                return (F) entity.getPassword();
//            }
//
//            @Override
//            public Password setValue(Password entity, F param) {
//                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Password");
//                return (Password) entity.setPassword(param);
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
