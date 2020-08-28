package com.chrgue.springreact;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chrgue.springreact.model.Post;
import com.chrgue.springreact.repository.PostRepository;

@SpringBootApplication
public class SpringReactApplication {

	@Bean
	CommandLineRunner initPosts(PostRepository repository) {
		return args -> {

			// initialize with some data
			Stream.of("This is a Test", "This is another Test", "Tests Tests Tests", "Stop It!").forEach(text -> {
				Post p = new Post();
				p.setText(text);
				repository.save(p);
			});

			System.out.println("---------------------------------");
			repository.findAll().forEach(System.out::println);
			System.out.println("---------------------------------");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactApplication.class, args);
	}
}
