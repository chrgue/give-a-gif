package com.chrgue.springreact.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.chrgue.springreact.model.Post;

@Repository
public class InMemoryPostRepository implements PostRepository {

	private static final AtomicLong COUNTER = new AtomicLong();
	private final ConcurrentMap<Long, Post> posts = new ConcurrentHashMap<Long, Post>();

	@Override
	public Post save(Post post) {
		Long id = post.getId();

		if (id == null) {
			id = COUNTER.incrementAndGet();
			post.setId(id);
		}

		this.posts.put(id, post);
		return post;
	}

	@Override
	public Stream<Post> findAll() {
		return posts.values().stream();
	}

}
