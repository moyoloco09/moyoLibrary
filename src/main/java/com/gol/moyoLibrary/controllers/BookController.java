package com.gol.moyoLibrary.controllers;
import com.gol.moyoLibrary.models.BookModel;
import com.gol.moyoLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin()
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping()
    public BookModel saveBook(@RequestBody BookModel book) {
        return bookService.saveBook(book);
    }
    @GetMapping()
    public List<BookModel> getAllBooks(){
        return bookService.getAllBooks();
    }
    @DeleteMapping("/deleteById={id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBookById(id);
    }
    @PutMapping("/updateById={id}")
    public BookModel updateBook(@PathVariable Long id, @RequestBody BookModel book){
        return bookService.updateBookById(id, book);
    }
}