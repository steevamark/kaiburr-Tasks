package com.api.springmangodb.resource;
import java.util.List;
import java.util.Optional;

import com.api.springmangodb.model.Book;
import com.api.springmangodb.repository.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankController {
    private final BookRepository repository;

    public BankController(BookRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        repository.save(book);
        return "Added book with id : " + book.getId();
    }
    @GetMapping("/findAllBooks")
  public List<Book> getBooks(){
        return repository.findAll();
  }
  @GetMapping("/findAllBooks/{id}")
  public Optional<Book> getBook(@PathVariable int id){
        return repository.findById(id);
  }
  @DeleteMapping("/delete/{id}/{authorName}")
  public String  deleteBook(@PathVariable int id ){
        repository.deleteById(id);

        return "book deleted with id : "+id;

  }

}
