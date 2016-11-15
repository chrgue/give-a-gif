package com.chrgue.nashorn.repository;

import com.chrgue.nashorn.model.Post;

public interface PostRepository {

	public Post save(Post post);

	public Iterable<Post> findAll();
}
