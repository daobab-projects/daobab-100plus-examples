package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.sql.Timestamp;

public interface LastUpdate<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * ACTOR: TIMESTAMP
     * ADDRESS: TIMESTAMP
     * CATEGORY: TIMESTAMP
     * CITY: TIMESTAMP
     * COUNTRY: TIMESTAMP
     * CUSTOMER: TIMESTAMP
     * FILM: TIMESTAMP
     * FILM_ACTOR: TIMESTAMP
     * FILM_CATEGORY: TIMESTAMP
     * INVENTORY: TIMESTAMP
     * LANGUAGE: TIMESTAMP
     * PAYMENT: TIMESTAMP
     * RENTAL: TIMESTAMP
     * STAFF: TIMESTAMP
     * STORE: TIMESTAMP
     */
    default Timestamp getLastUpdate(){return getColumnParam("LastUpdate");}
    @SuppressWarnings("unchecked")
    default E setLastUpdate(Timestamp val){setColumnParam("LastUpdate",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,Timestamp,LastUpdate> colLastUpdate(){
        return new Column<E,Timestamp,LastUpdate>() {

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
            public Class<Timestamp> getFieldClass(){
                return  Timestamp.class;
            }

            @Override
            public Timestamp getValue(LastUpdate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"LastUpdate");
                return  entity.getLastUpdate();
            }

            @Override
            public void setValue(LastUpdate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"LastUpdate");
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
