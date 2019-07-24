package com.data.springboot_data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
public class StartApplication{
    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private  BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);

    }

    @Bean //init bean to insert 3 books into h2 database
    CommandLineRunner initDatabase(BookRepository repository){
        return args ->{ repository.save(new Book("The Kite Runner", "Khaled Hosseini", new BigDecimal("17.07")));
                        repository.save(new Book("The Alchemist", "Paulo Coelho", new BigDecimal("23.75")));
                        repository.save(new Book("Brave New World", "Aldous Huxley", new BigDecimal("18.5")));

        };
    }

}

