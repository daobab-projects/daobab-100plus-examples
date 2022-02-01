package io.daobab.demo;

import io.daobab.demo.base.ServiceBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static Logger log= LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        AtomicBoolean singleExecution= new AtomicBoolean(false);

        Arrays.stream(args.getSourceArgs())
                .filter(s -> s.startsWith("io.daobab"))
                .map(s -> {
                    try {
                        return Class.forName(s);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .filter(ServiceBase.class::isAssignableFrom)
                .peek(c->log.info("*********************************************************************************************"))
                .peek(c->log.info("executing an example: "+c.getName()))
                .peek(c->log.info("*********************************************************************************************"))
                .map(applicationContext::getBean)
                .map(ServiceBase.class::cast)
                .peek(x-> singleExecution.set(true))
                .forEach(this::execute);


        if (singleExecution.get()){
            log.info("*************************************** -= the end =- ***************************************");
            System.exit(0);
        }

    }

    private <T> void execute(ServiceBase<T> sb){
        sb.beforeCall();
        sb.afterCall(sb.call());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
