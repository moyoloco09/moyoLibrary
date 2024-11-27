package com.gol.moyoLibrary.repositories;
import com.gol.moyoLibrary.models.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends CrudRepository<BookModel, Long>{
    public boolean existsByTitle(String title);
    public List<BookModel> findByTitle(String title);
    public List<BookModel> findByAuthor(String author);
}
