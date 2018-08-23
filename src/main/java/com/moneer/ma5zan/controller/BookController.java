package com.moneer.ma5zan.controller;

import org.springframework.beans.BeanUtils;
import com.moneer.ma5zan.model.Book;
import com.moneer.ma5zan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ma5zan/v1/")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @RequestMapping(value = "books", method = RequestMethod.GET)
  public List<Book> list() {
    return bookRepository.findAll();
  }

  @RequestMapping(value = "books", method = RequestMethod.POST)
  public Book create(@RequestBody Book book) {
    return bookRepository.saveAndFlush(book);
  }

  @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
  public Book get(@PathVariable Long id) {
    return bookRepository.findById(id).get();
  }

  @RequestMapping(value = "books/{id}", method = RequestMethod.PUT)
  public Book update(@PathVariable Long id, @RequestBody Book book) {
    Book existingBook = bookRepository.findById(id).get();
    BeanUtils.copyProperties(book, existingBook);
    return bookRepository.saveAndFlush(existingBook);
  }

  @RequestMapping(value = "books/{id}", method = RequestMethod.DELETE)
  public Book delete(@PathVariable Long id) {
    Book existingBook = bookRepository.findById(id).get();
    bookRepository.delete(existingBook);
    return existingBook;
  }
}
