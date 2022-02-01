package io.daobab.demo.dao.table.enhanced;

import io.daobab.demo.dao.table.City;
import io.daobab.demo.dao.table.Country;
import io.daobab.model.Column;
import io.daobab.model.EnhancedEntity;
import io.daobab.query.base.Query;
import io.daobab.query.base.QueryJoin;

import java.util.Arrays;
import java.util.List;

public class CountryCity extends City implements
        io.daobab.demo.dao.column.Country<City>,
        EnhancedEntity {

    private static final Country tabCountry = new Country();


    @Override
    public List<Column> joinedColumns() {
        return Arrays.asList(
                tabCountry.colCountry()
        );
    }


    @Override
    public <Q extends Query & QueryJoin<Q>> Q enhanceQuery(Q query) {
        return (Q) query
                .join(tabCountry, colCountryId());
    }
}
