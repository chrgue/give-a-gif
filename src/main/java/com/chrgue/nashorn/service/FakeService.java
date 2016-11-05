package com.chrgue.nashorn.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class FakeService {
	
	
	public List<String> createUuids(int count) {
		return IntStream.range(0, count).boxed()
				.map(index -> UUID.randomUUID().toString())
				.collect(Collectors.toList());
	}
}
