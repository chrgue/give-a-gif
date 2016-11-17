package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.chrgue.nashorn.TryNashornApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TryNashornApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TryNashornApplicationTests {

	@Value("${local.server.port}")
	int port;

	@Test
	public void testHome() {
		RestAssured.given()
			.spec(new RequestSpecBuilder().build())
			.baseUri("http://localhost")
			.port(port)
			.when()
			.get("/")
			.then()
			.statusCode(200);
	}
}
