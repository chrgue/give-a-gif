package com.chrgue.springreact.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.chrgue.springreact.model.Post;

public class InMemoryPostRepositoryTest {

	private PostRepository repository;

	@Before
	public void setup() {
		repository = new InMemoryPostRepository();

		repository.save(new Post());
		repository.save(new Post());
	}

	@Test
	public void hasAllElements() {
		Stream<Post> postStream = repository.findAll();
		assertEquals(2, postStream.count());
	}

	@Test
	public void postHasId() {
		Stream<Post> postStream = repository.findAll();
		Optional<Post> firstPost = postStream.findFirst();

		assertNotNull(firstPost.get().getId());
	}

}
