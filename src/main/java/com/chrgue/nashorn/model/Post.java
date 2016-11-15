package com.chrgue.nashorn.model;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Post {
	String text;
	Long id;
}
