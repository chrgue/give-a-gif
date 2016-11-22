package com.chrgue.nashorn.repository;

import java.util.stream.Stream;

import com.chrgue.nashorn.model.Post;

public interface PostRepository {

	public Post save(Post post);

	public Stream<Post> findAll();
}
