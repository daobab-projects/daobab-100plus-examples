package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface CityId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getCityId() {
        return readParam("CityId");
    }

    default E setCityId(F val) {
        return storeParam("CityId", val);
    }


    /**
     * table:ADDRESS,type:SMALLINT,size:16,nullable:false
     * table:CITY,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, CityId> colCityId() {
        return ColumnCache.INSTANCE.getColumn("CityId", "CITY_ID", (Table<?>) this, Integer.class);
    }


}
