package com.gol.moyoLibrary.services;
import com.gol.moyoLibrary.models.BookModel;
import com.gol.moyoLibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public BookModel saveBook(BookModel book){
        if(bookRepository.existsByTitle(book.getTitle())){
            return new BookModel(0L, "A book with the same title already exists", "", 0, "", "");
        }
        return bookRepository.save(book);};
    public List<BookModel> getAllBooks(){return (List<BookModel>)bookRepository.findAll();}
    public Optional<BookModel> findBookById(Long id){return (Optional<BookModel>)bookRepository.findById(id);};
    public List<BookModel> findBookByTitle(String title){return (List<BookModel>)bookRepository.findByTitle(title);};
    public List<BookModel> findBookByAuthor(String author){return (List<BookModel>)bookRepository.findByAuthor(author);};
    public String deleteBookById(Long id){
        String response;
        Optional<BookModel>foundBook=bookRepository.findById(id);
        if(foundBook.isPresent()){
            bookRepository.delete(foundBook.get());
            response="Book deleted successfully";
        }
        else{
            response="Book not found";
        }
        return response;
    }
    public BookModel updateBookById(Long id, BookModel book){
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setYearPublished(book.getYearPublished());
                    existingBook.setGenre(book.getGenre());
                    existingBook.setDescription(book.getDescription());
                    return bookRepository.save(existingBook);
                })
                .orElse(new BookModel(0L, "Book not found", "", 0, "", ""));
    }
}
