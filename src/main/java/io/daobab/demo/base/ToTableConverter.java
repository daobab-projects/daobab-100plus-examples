package io.daobab.demo.base;

import io.daobab.model.Entity;
import io.daobab.model.FlatPlate;
import io.daobab.model.Plate;
import io.daobab.model.TableColumn;
import io.daobab.result.FlatPlates;
import io.daobab.target.buffer.single.Plates;

import java.util.Collection;

public interface ToTableConverter {


    String OPEN_TABLE = "<table class=\"table table-hover\">";
    String OPEN_TH = "<th scope=\"col\">";
    String OPEN_TD = "<td>";
    String OPEN_TR = "<tr>";
    String OPEN_THEAD = "<thead>";
    String OPEN_TBODY = "<tbody>";
    String CLOSE_TABLE = "</table>";
    String CLOSE_TH = "</th>";
    String CLOSE_TD = "</td>";
    String CLOSE_TR = "</tr>";
    String CLOSE_THEAD = "</thead>";
    String CLOSE_TBODY = "</tbody>";


    default <V> String resultToTable(V obj) {
        if (obj == null) return "null";
        if (obj instanceof Entity) {
            return entityToTable((Entity) obj);
        } else if (obj instanceof Plate) {
            return getPlateRow((Plate) obj);
        } else if (obj instanceof FlatPlate) {
            return getFlatPlateRow((FlatPlate) obj);
        } else if (obj instanceof Plates) {
            return PlatesToTable((Plates) obj);
        } else if (obj instanceof FlatPlates) {
            return flatPlatesToTable((FlatPlates) obj);
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;

            if (!collection.isEmpty() && collection.iterator().next() instanceof FlatPlate) {
                return flatsToTable((Collection<FlatPlate>) collection);
            } else if (!collection.isEmpty() && collection.iterator().next() instanceof Entity) {
                return entitiesToTable((Collection<Entity>) collection);
            } else {
                return cellsToTable(collection);
            }
        } else {
            return getCellRow(obj).toString();
        }

        // return "";
    }

    private String entityToTable(Entity obj) {
        String table = OPEN_TABLE +
                getHeader(obj) +
                getRow(obj) +
                CLOSE_TABLE;

        return table;
    }


    private String PlatesToTable(Plates objects) {
        if (objects.isEmpty()) return "";
        var table = new StringBuffer();
        table.append(OPEN_TABLE)
                .append(getHeader(objects.iterator().next()));

        for (Plate obj : objects) {
            table.append(getPlateRow(obj));
        }

        table.append(CLOSE_TABLE);

        return table.toString();
    }

    private String flatPlatesToTable(FlatPlates objects) {
        if (objects.isEmpty()) return "";
        var table = new StringBuffer();
        table.append(OPEN_TABLE)
                .append(getHeader(objects.iterator().next()));

        for (FlatPlate obj : objects) {
            table.append(getFlatPlateRow(obj));
        }

        table.append(CLOSE_TABLE);

        return table.toString();
    }

    private String entitiesToTable(Collection<Entity> objects) {
        if (objects.isEmpty()) return "";
        var table = new StringBuffer();
        table.append(OPEN_TABLE)
                .append(getHeader(objects.iterator().next()));

        for (Entity obj : objects) {
            table.append(getRow(obj));
        }

        table.append(CLOSE_TABLE);

        return table.toString();
    }

    private String flatsToTable(Collection<FlatPlate> objects) {
        if (objects.isEmpty()) return "";
        var table = new StringBuffer();
        table.append(OPEN_TABLE)
                .append(getHeader(objects.iterator().next()));

        for (FlatPlate obj : objects) {
            table.append(getRow(obj));
        }

        table.append(CLOSE_TABLE);

        return table.toString();
    }


    private <V> String cellsToTable(Collection<V> objects) {
        if (objects.isEmpty()) return "";
        var table = new StringBuffer();
        table.append(OPEN_TABLE)
                .append(getCellHeader(objects.iterator().next().getClass().getSimpleName()));

        for (var obj : objects) {
            table.append(getCellRow(obj));
        }

        table.append(CLOSE_TABLE);

        return table.toString();
    }

    private <V> StringBuffer getCellHeader(String label) {
        var table = new StringBuffer();
        table.append(OPEN_THEAD).append(OPEN_TR);
        table.append(OPEN_TH).append(label).append(CLOSE_TH);
        table.append(CLOSE_TR).append(CLOSE_THEAD);
        return table;
    }

    private StringBuffer getHeader(Entity obj) {
        var table = new StringBuffer();
        table.append(OPEN_THEAD).append(OPEN_TR);
        for (TableColumn col : obj.columns()) {
            table.append(OPEN_TH).append(col.getColumn().getColumnName()).append(CLOSE_TH);
        }
        table.append(CLOSE_TR).append(CLOSE_THEAD);
        return table;
    }

    private StringBuffer getHeader(FlatPlate obj) {
        var table = new StringBuffer();
        table.append(OPEN_THEAD).append(OPEN_TR);
        for (var col : obj.keySet()) {
            table.append(OPEN_TH).append(col).append(CLOSE_TH);
        }
        table.append(CLOSE_TR).append(CLOSE_THEAD);
        return table;
    }


    private <V> StringBuffer getCellRow(V obj) {
        var table = new StringBuffer();
        table.append(OPEN_TBODY).append(OPEN_TR);
        table.append(OPEN_TD).append(obj).append(CLOSE_TD);
        table.append(CLOSE_TR).append(CLOSE_TBODY);
        return table;
    }

    private StringBuffer getRow(Entity obj) {
        var table = new StringBuffer();
        table.append(OPEN_TBODY).append(OPEN_TR);
        for (TableColumn col : obj.columns()) {
            var val = col.getColumn().getThisValue();
            table.append(OPEN_TD).append(val == null ? "" : val).append(CLOSE_TD);
        }
        table.append(CLOSE_TR).append(CLOSE_TBODY);
        return table;
    }

    private StringBuffer getRow(FlatPlate obj) {
        var table = new StringBuffer();
        table.append(OPEN_TBODY).append(OPEN_TR);
        for (var col : obj.keySet()) {
            var val = obj.get(col);
            table.append(OPEN_TD).append(val == null ? "" : val).append(CLOSE_TD);
        }
        table.append(CLOSE_TR).append(CLOSE_TBODY);
        return table;
    }

    private StringBuffer getHeader(Plate obj) {
        var table = new StringBuffer();
        table.append(OPEN_THEAD).append(OPEN_TR);
        for (String key : obj.keySet()) {
            table.append(OPEN_TH).append(key).append(CLOSE_TH);
        }
        table.append(CLOSE_TR).append(CLOSE_THEAD);
        return table;
    }


    private String getPlateRow(Plate obj) {
        var table = new StringBuffer();
        table.append(OPEN_TBODY).append(OPEN_TR);
        for (String key : obj.keySet()) {
            table.append(OPEN_TH).append((String) obj.getValue(key)).append(CLOSE_TH);
        }
        table.append(CLOSE_TR).append(CLOSE_TBODY);
        return table.toString();
    }


    private String getFlatPlateRow(FlatPlate obj) {
        var table = new StringBuffer();
        table.append(OPEN_TBODY).append(OPEN_TR);
        for (TableColumn key : obj.columns()) {
            table.append(OPEN_TH).append((String) obj.get(key.getColumn())).append(CLOSE_TH);
        }
        table.append(CLOSE_TR).append(CLOSE_TBODY);
        return table.toString();
    }


}
