package io.daobab.demo.example.base;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.parser.ParserGeneral;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Configuration
public class InMemoryAppender extends AppenderBase<ILoggingEvent> implements ParserGeneral {

    //:(
    private static ConcurrentMap<Long, ILoggingEvent> eventMap = new ConcurrentHashMap<>();

    @Override
    protected void append(ILoggingEvent event) {
        eventMap.put(System.nanoTime(), event);
    }

    public Map<Long, ILoggingEvent> getEventMap() {
        return eventMap;
    }

    public void clear() {
        eventMap.clear();
    }

    public String getHistory() {
        var timeborder = System.currentTimeMillis() - 5 * 60 * 1000 + 1000; //5 min
        var map = eventMap;
        var sb = new StringBuffer();


        var keys = new TreeSet<Long>();

        keys.addAll(map.keySet());

        for (Iterator<Long> it = keys.descendingIterator(); it.hasNext(); ) {
            Long key = it.next();
            if (key < timeborder) {
                map.remove(key);
                continue;
            }
            var record = map.get(key);
            boolean query = record.getLoggerName().endsWith(SakilaDataBase.class.getSimpleName());
            var msg = record.getMessage();
            if ("<hr>".equals(msg)) {
                sb.append(msg);
                continue;
            }
            sb.append(toSting(new Date(record.getTimeStamp()), "HH:mm:SSS - ")).append(query ? "<b><big><code>" + record.getMessage() + "</b></big></code>" : record.getMessage()).append("<br>");
        }

        return sb.toString();
    }
}