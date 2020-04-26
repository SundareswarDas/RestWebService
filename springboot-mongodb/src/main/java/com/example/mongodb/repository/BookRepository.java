package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.model.Book;

public interface BookRepository  extends MongoRepository<Book , Integer>{
	
	

}
