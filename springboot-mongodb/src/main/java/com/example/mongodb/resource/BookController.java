package com.example.mongodb.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.model.Book;
import com.example.mongodb.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@CrossOrigin(origins="*")
	@PostMapping("/addBook")
	public Optional<Book> saveBook(@RequestBody Book book)
	{
		repository.save(book);
		//return "Added book with id : " +book.getId();
		//return "book added";
		return repository.findById((book.getId()));
	}
	@CrossOrigin(origins="*")
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return repository.findAll();
	}
	@CrossOrigin(origins="*")
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		return repository.findById(id);
	}
	@CrossOrigin(origins="*")
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id){
		repository.deleteById(id);
		return "book deleted with id : "+id;
	}
}
