package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Email<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * CUSTOMER: VARCHAR
     * STAFF: VARCHAR
     */
    default String getEmail(){return getColumnParam("Email");}
    @SuppressWarnings("unchecked")
    default E setEmail(String val){setColumnParam("Email",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,String,Email> colEmail(){
        return new Column<E,String,Email>() {

            @Override
            public String getColumnName() {
                return "EMAIL";
            }

            @Override
            public String getFieldName() {
                return "Email";
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
            public String getValue(Email entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Email");
                return  entity.getEmail();
            }

            @Override
            public void setValue(Email entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Email");
                entity.setEmail(param);
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
