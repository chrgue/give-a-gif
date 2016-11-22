package com.chrgue.nashorn;

import static com.chrgue.nashorn.RegexMatcher.matches;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TryNashornApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TryNashornApplicationTests {

	@Value("${local.server.port}")
	int port;

	@Test
	public void testHome() {
		RestAssured.given()
				.baseUri("http://localhost")
				.port(port)
				.when()
				.get("/")
				.then()
				.statusCode(200)
				.body(not(matches(".*\\{.*\\}.*")))
				.body("html.body.div.@class", is("container"));
	}
}
