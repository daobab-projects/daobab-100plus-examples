package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.InventoryId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.demo.dao.column.StoreId;
import io.daobab.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableName(value = "INVENTORY")
public class Inventory extends Table<Inventory> implements
        InventoryId<Inventory, BigDecimal>,
        FilmId<Inventory, Integer>,
        StoreId<Inventory, Integer>,
        LastUpdate<Inventory, LocalDateTime>,

        PrimaryKey<Inventory, BigDecimal, InventoryId> {


    public Inventory() {
        super();
    }

    public Inventory(Map<String, Object> parameters) {
        super(parameters);
    }


    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colInventoryId()).primaryKey().size(32),
                new TableColumn(colFilmId()).size(16),
                new TableColumn(colStoreId()).size(8),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Inventory, BigDecimal, InventoryId> colID() {
        return colInventoryId();
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
