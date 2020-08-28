package com.chrgue.springreact.repository;

import java.util.stream.Stream;

import com.chrgue.springreact.model.Post;

public interface PostRepository {
	Post save(Post post);
	Stream<Post> findAll();
}
