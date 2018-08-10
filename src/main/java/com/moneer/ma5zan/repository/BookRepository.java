package com.moneer.ma5zan.repository;

import com.moneer.ma5zan.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByTitle(String title);//List to support multiple volumes/edition
  List<Book> findByAuthor(String author);
  List<Book> findByReleaseYear(Date releaseYear);
  List<Book> findByEditor(String editor);
  List<Book> findByEdition(int edition);
  List<Book> findByPublisher(String publisher);
  List<Book> findByCoverImage(String coverImage);
  List<Book> findByDescription(String description);
  List<Book> findByVolumeNumber(int volumeNumber);
  List<Book> findByPagesCount(int pagesCount);
}
