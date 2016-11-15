package com.chrgue.nashorn.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.chrgue.nashorn.model.Post;

@Repository
public class InMemoryPostRepository implements PostRepository {

	static private AtomicLong counter = new AtomicLong();
	private final ConcurrentMap<Long, Post> posts = new ConcurrentHashMap<Long, Post>();

	@Override
	public Post save(Post post) {
		Long id = post.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			post.setId(id);
		}
		this.posts.put(id, post);
		return post;

	}

	@Override
	public Iterable<Post> findAll() {
		return posts.values();
	}

}
