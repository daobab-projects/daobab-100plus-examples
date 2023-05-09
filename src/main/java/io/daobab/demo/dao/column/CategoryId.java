package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface CategoryId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCategoryId() {
        return getColumnParam("CategoryId");
    }

    @SuppressWarnings("unchecked")
    default E setCategoryId(F val) {
        setColumnParam("CategoryId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CATEGORY,type:TINYINT,size:8,nullable:false
     * table:FILM_CATEGORY,type:TINYINT,size:8,nullable:false
     */
    default Column<E, F, CategoryId> colCategoryId() {
        return new Column<E, F, CategoryId>() {

            @Override
            public String getColumnName() {
                return "CATEGORY_ID";
            }

            @Override
            public String getFieldName() {
                return "CategoryId";
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
            public F getValue(CategoryId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "CategoryId");
                return (F) entity.getCategoryId();
            }

            @Override
            public void setValue(CategoryId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "CategoryId");
                entity.setCategoryId(param);
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
