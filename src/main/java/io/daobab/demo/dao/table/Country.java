package io.daobab.demo.dao.table;

import io.daobab.creation.DaobabCache;
import io.daobab.demo.dao.column.CountryId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "COUNTRY")
public class Country extends Table<Country> implements
	CountryId<Country>,
	io.daobab.demo.dao.column.Country<Country>,
	LastUpdate<Country>,

	PrimaryKey<Country,Integer,CountryId>
	{

	public Country() {
		super();
	}

        public Country(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colCountryId()).primaryKey().size(16),
			new TableColumn(colCountry()).size(50),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Country, Integer, CountryId> colID() {
		return colCountryId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		PrimaryKey<?, ?, ?> other = (PrimaryKey<?, ?, ?>) obj;
		return Objects.equals(getId(), other.getId());
	}


}
