package com.moneer.ma5zan;

import com.moneer.ma5zan.model.Book;
import com.moneer.ma5zan.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BookRepositoryIntegrationTest {

  @Autowired
  private BookRepository bookRepository;

  @Before
  public void init() {
    Book b = new Book();
    bookRepository.saveAndFlush(b);
  }

  @Test
  public void TestGetAll() {
    List<Book> books = bookRepository.findAll();
    assertThat(books.size(), is(greaterThanOrEqualTo(1)));
  }
}
