package org.leo.ReactiveService.repository;

import org.leo.ReactiveService.entity.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
	
}
