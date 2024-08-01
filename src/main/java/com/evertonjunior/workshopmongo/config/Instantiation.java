package com.evertonjunior.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.evertonjunior.workshopmongo.domain.Post;
import com.evertonjunior.workshopmongo.domain.User;
import com.evertonjunior.workshopmongo.repository.PostRepository;
import com.evertonjunior.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, Instant.now(),"Partiu viagem ", "Vou viajar para o Rio de Janeiro, beijoss!", maria );
		Post post2 = new Post(null, Instant.now(),"Bom dia ", "Acordei feliz hoje", alex );
		
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
