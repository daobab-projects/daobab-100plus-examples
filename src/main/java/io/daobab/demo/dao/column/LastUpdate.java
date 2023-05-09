package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.time.LocalDateTime;
import java.util.Objects;

public interface LastUpdate<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getLastUpdate() {
        return getColumnParam("LastUpdate");
    }

    @SuppressWarnings("unchecked")
    default E setLastUpdate(F val) {
        setColumnParam("LastUpdate", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ACTOR,type:TIMESTAMP,size:26,nullable:false
     * table:ADDRESS,type:TIMESTAMP,size:26,nullable:false
     * table:CATEGORY,type:TIMESTAMP,size:26,nullable:false
     * table:CITY,type:TIMESTAMP,size:26,nullable:false
     * table:COUNTRY,type:TIMESTAMP,size:26,nullable:false
     * table:CUSTOMER,type:TIMESTAMP,size:26,nullable:false
     * table:FILM,type:TIMESTAMP,size:26,nullable:false
     * table:FILM_ACTOR,type:TIMESTAMP,size:26,nullable:false
     * table:FILM_CATEGORY,type:TIMESTAMP,size:26,nullable:false
     * table:INVENTORY,type:TIMESTAMP,size:26,nullable:false
     * table:LANGUAGE,type:TIMESTAMP,size:26,nullable:false
     * table:PAYMENT,type:TIMESTAMP,size:26,nullable:false
     * table:RENTAL,type:TIMESTAMP,size:26,nullable:false
     * table:STAFF,type:TIMESTAMP,size:26,nullable:false
     * table:STORE,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, LastUpdate> colLastUpdate() {
        return new Column<E, F, LastUpdate>() {

            @Override
            public String getColumnName() {
                return "LAST_UPDATE";
            }

            @Override
            public String getFieldName() {
                return "LastUpdate";
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
            public F getValue(LastUpdate entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "LastUpdate");
                return (F) entity.getLastUpdate();
            }

            @Override
            public void setValue(LastUpdate entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "LastUpdate");
                entity.setLastUpdate(param);
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
