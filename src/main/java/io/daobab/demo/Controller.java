package io.daobab.demo;

import io.daobab.demo.dao.SakilaTables;
import io.daobab.demo.base.InMemoryAppender;
import io.daobab.demo.base.ServiceBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;


@RestController
@RequestMapping("/")
public class Controller implements SakilaTables {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private InMemoryAppender inMemoryConsole;

    @Autowired
    private List<ServiceBase> examples;

    private void executeExampleNo(String no) {
        if (no == null) return;
        for (ServiceBase service : examples) {
            if (service.getClass().getSimpleName().equalsIgnoreCase(no)) {
                service.callService();
                return;
            }
        }
        log.info("I can't find such example");
    }


    @GetMapping("/")
    public String page() {
        String rv = load();
        rv = rv.replace("_S_SERVICES_E_", getServices(null));
        return rv.replace("_S_LOG_E_", inMemoryConsole.getHistory());
    }

    private String getServices(String selected) {
        var sb = new StringBuilder();
        sb.append("<option" + (selected == null ? " selected " : "") + ">Choose Daobab example to execute</option>");
        for (var service : examples) {

            boolean chosen = service.getClass().getSimpleName().equals(selected);
            sb.append("<option " + (chosen ? " selected " : "") + "value=\"" + service.getClass().getSimpleName() + "\">").append(service.getClass().getSimpleName()).append("</option>");
        }
        return sb.toString();
    }

    @GetMapping("/test")
    public String test(@RequestParam(value = "name", required = false) String no) {
        System.out.println("wywoluje "+no);
        inMemoryConsole.clear();
        if (no != null) executeExampleNo(no);

        String rv = load();
        rv = rv.replace("_S_SERVICES_E_", getServices(no));
        return rv.replace("_S_LOG_E_", inMemoryConsole.getHistory());
    }

    @GetMapping("/log")
    public String log() {
        return inMemoryConsole.getHistory();
    }


    public String load() {
        try {
            return new Scanner(new ClassPathResource("page.html").getInputStream(), "UTF-8").useDelimiter("\\A").next();
//            return content;//DictTemplateKey.TEMP_APP_URL.replaceAll(content,getURL());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}