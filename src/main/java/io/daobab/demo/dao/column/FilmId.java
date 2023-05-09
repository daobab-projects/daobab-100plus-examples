package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface FilmId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getFilmId() {
        return getColumnParam("FilmId");
    }

    @SuppressWarnings("unchecked")
    default E setFilmId(F val) {
        setColumnParam("FilmId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:SMALLINT,size:16,nullable:false
     * table:FILM_ACTOR,type:SMALLINT,size:16,nullable:false
     * table:FILM_CATEGORY,type:SMALLINT,size:16,nullable:false
     * table:FILM_TEXT,type:SMALLINT,size:16,nullable:false
     * table:INVENTORY,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, FilmId> colFilmId() {
        return new Column<E, F, FilmId>() {

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
            public Class getFieldClass() {
                return Integer.class;
            }

            @Override
            public F getValue(FilmId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "FilmId");
                return (F) entity.getFilmId();
            }

            @Override
            public void setValue(FilmId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "FilmId");
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
