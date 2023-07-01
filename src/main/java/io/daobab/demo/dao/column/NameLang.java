package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.demo.dao.Lang;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

public interface NameLang<E extends Entity> extends EntityRelationMap<E> {


    /**
     * db name: NAME,
     * db type: VARCHAR
     */
    default Lang getName() {
        return readParam("Name");
    }

    default E setName(Lang val) {
        return storeParam("Name", val);
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, Lang, NameLang> colName() {
        return ColumnCache.INSTANCE.getColumn("Name","NAME",(Table<?>)this,Lang.class);
    }


//
//    default Column<E, Lang, NameLang> colName() {
//        return new Column<E, Lang, NameLang>() {
//
//            @Override
//            public String getColumnName() {
//                return "NAME";
//            }
//
//            @Override
//            public String getFieldName() {
//                return "Name";
//            }
//
//            @Override
//            public E getInstance() {
//                return getEntity();
//            }
//
//            @Override
//            public Class<Lang> getFieldClass() {
//                return Lang.class;
//            }
//
//            @Override
//            public Lang getValue(NameLang entity) {
//                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Name");
//                return entity.getName();
//            }
//
//
//            @Override
//            public NameLang setValue(NameLang entity, Lang param) {
//                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Name");
//                return (NameLang) entity.setName(param);
//            }
//
//            public void setFieldValue(NameLang entity, String param) {
//                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Name");
//                entity.setName(Lang.valueOf(param));
//            }
//
//            @Override
//            public int hashCode() {
//                return toString().hashCode();
//            }
//
//            @Override
//            public String toString() {
//                return getEntityClass().getName() + "." + getFieldName();
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                if (this == obj) return true;
//                if (obj == null) return false;
//                if (getClass() != obj.getClass()) return false;
//                Column other = (Column) obj;
//                return Objects.equals(hashCode(), other.hashCode());
//            }
//        };
//    }

}
