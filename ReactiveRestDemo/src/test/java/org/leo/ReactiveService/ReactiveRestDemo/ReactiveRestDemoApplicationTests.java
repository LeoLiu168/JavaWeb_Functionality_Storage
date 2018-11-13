package org.leo.ReactiveService.ReactiveRestDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leo.ReactiveService.entity.Book;
import org.leo.ReactiveService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactiveRestDemoApplicationTests {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private BookRepository bookRepository;

	@Test
	public void saveUser() {
		Book user = new Book();
		bookRepository.deleteAll().subscribe();
		webTestClient.post().uri("/users").contentType(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(user), Book.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString())
		.expectBody()
		.jsonPath("$.name").isEqualTo("Leo");

	}

}
