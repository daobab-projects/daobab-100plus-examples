package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Phone<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * ADDRESS: VARCHAR
     */
    default String getPhone(){return getColumnParam("Phone");}
    @SuppressWarnings("unchecked")
    default E setPhone(String val){setColumnParam("Phone",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,String,Phone> colPhone(){
        return new Column<E,String,Phone>() {

            @Override
            public String getColumnName() {
                return "PHONE";
            }

            @Override
            public String getFieldName() {
                return "Phone";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class<String> getFieldClass(){
                return  String.class;
            }

            @Override
            public String getValue(Phone entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Phone");
                return  entity.getPhone();
            }

            @Override
            public void setValue(Phone entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Phone");
                entity.setPhone(param);
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
