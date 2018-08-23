package com.moneer.ma5zan;


import com.moneer.ma5zan.controller.BookController;
import com.moneer.ma5zan.model.Book;
import com.moneer.ma5zan.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Optional;

public class BookControllerTests {

  @InjectMocks
  private BookController bc;

  @Mock
  private BookRepository bookRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testBookGet() {
    Optional<Book> mock_b = Optional.of(new Book());
    mock_b.get().setId(1L);

    when(bookRepository.findById(1L)).thenReturn(mock_b);

    assertThat(bc.get(1L).get().getId(), is(1L));

    verify(bookRepository).findById(1L);
  }
}
