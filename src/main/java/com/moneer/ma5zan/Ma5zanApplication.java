package com.moneer.ma5zan;

import com.moneer.ma5zan.model.Book;
import com.moneer.ma5zan.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ma5zanApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ma5zanApplication.class, args);
	}
}
