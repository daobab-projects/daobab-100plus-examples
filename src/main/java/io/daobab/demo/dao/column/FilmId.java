package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface FilmId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * FILM: SMALLINT
     * FILM_ACTOR: SMALLINT
     * FILM_CATEGORY: SMALLINT
     * FILM_TEXT: SMALLINT
     * INVENTORY: SMALLINT
     */
    default Integer getFilmId(){return getColumnParam("FilmId");}
    @SuppressWarnings("unchecked")
    default E setFilmId(Integer val){setColumnParam("FilmId",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,Integer,FilmId> colFilmId(){
        return new Column<E,Integer,FilmId>() {

            @Override
            public String getColumnName() {
                return "FILM_ID";
            }

            @Override
            public String getFieldName() {
                return "FilmId";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class<Integer> getFieldClass(){
                return  Integer.class;
            }

            @Override
            public Integer getValue(FilmId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"FilmId");
                return  entity.getFilmId();
            }

            @Override
            public void setValue(FilmId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"FilmId");
                entity.setFilmId(param);
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
