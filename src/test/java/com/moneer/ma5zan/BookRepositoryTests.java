package com.moneer.ma5zan;

import static org.assertj.core.api.Assertions.assertThat;

import com.moneer.ma5zan.model.Book;
import com.moneer.ma5zan.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
//@Rollback(false)
public class BookRepositoryTests {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private BookRepository bookRepository;

  private final String LONG_NAME = "هذا اسم كتاب طويل لأغراض أختبار القدرة على الحفظ و الاسترداد من المخزن يجب علينا أن نكون على بينة من ما نختبر و تستدعي البينة أن نكون قادرين على الوثوق بالقدرة على التخزين و الاسترداد واحد اثنان ثلاثة و أربعة و خصسةو ستة و سبعة و ثمانية و تسعة و عشرة";

  private static Validator validator;

  @Before
  public void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  public void givenArabicTitle_shouldFindBook_whenQueryByTitle() {
    Book book = new Book("القرآن الكريم", "god");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByTitle("القرآن الكريم");
    assertThat(b).extracting(Book::getTitle).containsOnly(book.getTitle());
  }

  @Test
  public void givenMultipleBooks_shouldFindThemAll_whenQueryByTitle() {
    Book book1 = new Book("t1", "a1");
    Book book2 = new Book("t2", "a2");
    Book book3 = new Book("t3", "a3");
    testEntityManager.persist(book1);
    testEntityManager.persist(book2);
    testEntityManager.persist(book3);
    List<Book> b = bookRepository.findAll();
    assertThat(b).extracting(Book::getTitle).containsExactly(book1.getTitle(), book2.getTitle(), book3.getTitle());
  }

  @Test
  public void givenLongArabicTitle_shouldFindBook_whenQueryByTitle() {
    Book book = new Book(LONG_NAME, "mock");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByTitle(LONG_NAME);
    assertThat(b).extracting(Book::getTitle).containsOnly(book.getTitle());
  }

  @Test
  public void givenLongArabicAuthor_shouldFindBook_whenQueryByAuthor() {
    Book book = new Book("mock", LONG_NAME);
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByAuthor(LONG_NAME);
    assertThat(b).extracting(Book::getAuthor).containsOnly(book.getAuthor());
  }

  @Test
  public void givenNoTitle_shouldFail_whenValidated() {
    Book book = new Book("", "mock");
    assertThat(validator.validate(book).isEmpty()).isFalse();
  }

  @Test
  public void givenNoAuthor_shouldFail_whenValidated() {
    Book book = new Book("mock", "");
    assertThat(validator.validate(book).isEmpty()).isFalse();
  }

  @Test
  public void givenYear_shouldFindBook_WhenQueryByYear() {
    Book book = new Book("mock", "mock");
    Date year = new Date();
    year.setYear(660);
    book.setReleaseYear(year);
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByReleaseYear(book.getReleaseYear());
    assertThat(b).extracting(Book::getReleaseYear).containsOnly(book.getReleaseYear());
  }

  @Test
  public void givenEditor_shouldFindBook_WhenQueryByEditor() {
    Book book = new Book("mock", "mock");
    book.setEditor("me");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByEditor(book.getEditor());
    assertThat(b).extracting(Book::getEditor).containsOnly(book.getEditor());
  }

  @Test
  public void givenEdition_shouldFindBook_WhenQueryByEdition() {
    Book book = new Book("mock", "mock");
    book.setEdition(3);
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByEdition(book.getEdition());
    assertThat(b).extracting(Book::getEdition).containsOnly(book.getEdition());
  }

  @Test
  public void givenPublisher_shouldFindBook_WhenQueryByPublisher() {
    Book book = new Book("mock", "mock");
    book.setPublisher("house");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByPublisher(book.getPublisher());
    assertThat(b).extracting(Book::getPublisher).containsOnly(book.getPublisher());
  }

  @Test
  public void givenCoverImage_shouldFindBook_WhenQueryByCoverImage() {
    Book book = new Book("mock", "mock");
    book.setCoverImage("path");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByCoverImage(book.getCoverImage());
    assertThat(b).extracting(Book::getCoverImage).containsOnly(book.getCoverImage());
  }

  @Test
  public void givenDescription_shouldFindBook_WhenQueryByDescription() {
    Book book = new Book("mock", "mock");
    book.setDescription("description");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByDescription(book.getDescription());
    assertThat(b).extracting(Book::getDescription).containsOnly(book.getDescription());
  }

  @Test
  public void givenVolumeNumber_shouldFindBook_WhenQueryByVolumeNumber() {
    Book book = new Book("mock", "mock");
    book.setVolumeNumber(3);
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByVolumeNumber(book.getVolumeNumber());
    assertThat(b).extracting(Book::getVolumeNumber).containsOnly(book.getVolumeNumber());
  }

  @Test
  public void givenPagesCount_shouldFindBook_WhenQueryByPagesCount() {
    Book book = new Book("mock", "mock");
    book.setPagesCount(330);
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findByPagesCount(book.getPagesCount());
    assertThat(b).extracting(Book::getPagesCount).containsOnly(book.getPagesCount());
  }

  @Test
  public void givenBook_shouldNotBeFound_whenDeleted() {
    Book book = new Book("mock123", "mock");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findAll();
    assertThat(b).extracting(Book::getTitle).containsOnly(book.getTitle());
    b.clear();

    bookRepository.delete(book);
    b = bookRepository.findAll();
    assertThat(b.isEmpty()).isTrue();
  }

  @Test
  public void givenNewTitle_shouldBeUpdated() {
    Book book = new Book("mock123", "mock");
    testEntityManager.persist(book);
    List<Book> b = bookRepository.findAll();
    Long id = book.getId();
    assertThat(b).extracting(Book::getId).containsOnly(id);
    b.clear();

    String newTitle = "this is a new title";

    book.setTitle(newTitle);
    bookRepository.saveAndFlush(book);

    b = bookRepository.findAll();
    assertThat(b).extracting(Book::getId).containsOnly(id);
    assertThat(b).extracting(Book::getTitle).containsOnly(newTitle);
  }
}
