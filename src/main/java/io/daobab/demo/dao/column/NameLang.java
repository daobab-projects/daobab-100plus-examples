package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.demo.dao.Lang;
import io.daobab.model.*;

public interface NameLang<E extends Entity> extends RelatedTo<E>, MapHandler<E> {


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

    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, Lang, NameLang> colName() {
        return ColumnCache.INSTANCE.getColumn("Name", "NAME", (Table<?>) this, Lang.class);
    }


}
