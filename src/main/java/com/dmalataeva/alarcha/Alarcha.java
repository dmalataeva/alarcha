package com.dmalataeva.alarcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.dmalataeva.alarcha") // tell Spring to find rest controller methods here
@EntityScan("com/dmalataeva/alarcha/entities")
@EnableJpaRepositories(basePackages= "com.dmalataeva.alarcha.repositories")
public class Alarcha {
    public static void main(String[] args) {

        // start Spring Application
        // this application will start an HTTP server on http://localhost:8080
        // and bind com.dmalataeva.alarcha.controllers as API endpoints
        SpringApplication.run(Alarcha.class, args);
        System.out.println("started SpringBootApplication");

        //StoreFactory.initializeSession();
        //System.out.println("initialized session");

        //int res = OrderStore.addOrder(new Order(123, Instant.now(), "UberEats", 100500));
        //System.out.println("Result of addOrder: " + res);

        //res = OrderStore.addOrder(new Order(321, Instant.now(), "Nanaimo", 100500));

        //OrderStore.updateTotal(res, 666);
        //OrderStore.updateCollectMethod(3, "Елбасы креслосу");
        //OrderStore.deleteOrder(1);

    }

    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }*/
}
