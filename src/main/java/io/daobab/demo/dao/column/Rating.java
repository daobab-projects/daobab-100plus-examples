package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Rating<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * FILM: VARCHAR
     */
    default String getRating(){return getColumnParam("Rating");}
    @SuppressWarnings("unchecked")
    default E setRating(String val){setColumnParam("Rating",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,String,Rating> colRating(){
        return new Column<E,String,Rating>() {

            @Override
            public String getColumnName() {
                return "RATING";
            }

            @Override
            public String getFieldName() {
                return "Rating";
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
            public String getValue(Rating entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Rating");
                return  entity.getRating();
            }

            @Override
            public void setValue(Rating entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Rating");
                entity.setRating(param);
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
