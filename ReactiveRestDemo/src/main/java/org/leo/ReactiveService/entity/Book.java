package org.leo.ReactiveService.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@SuppressWarnings("unused")
	private String id;
	@SuppressWarnings("unused")
	private String title;
	@SuppressWarnings("unused")
	private String author;
	
}
