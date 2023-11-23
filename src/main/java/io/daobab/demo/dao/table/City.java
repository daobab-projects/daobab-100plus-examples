package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.CityId;
import io.daobab.demo.dao.column.CountryId;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "CITY")
public class City extends Table<City> implements
	CityId<City>,
	io.daobab.demo.dao.column.City<City>,
	CountryId<City>,
	LastUpdate<City>,

	PrimaryKey<City,Integer,CityId>
	{

	public City() {
		super();
	}

	protected City(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colCityId()).primaryKey().size(16),
			new TableColumn(colCity()).size(50),
			new TableColumn(colCountryId()).size(16),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< City, Integer, CityId> colID() {
		return colCityId();
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
