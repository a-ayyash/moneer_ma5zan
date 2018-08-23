package com.moneer.ma5zan.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @NotBlank(message = "Book must have a title")
  private String title;

  @NotBlank(message = "Book must have an author")
  private String author;

  @Column(name = "RELEASE_DATE")
  private Date releaseYear;

  @Column(name = "COVER_IMAGE")
  private String coverImage;

  @Column(name = "VOLUME_NUMBER")
  private int volumeNumber;

  @Column(name = "PAGES_COUNT")
  private int pagesCount;

  private String editor;
  private String publisher;
  private String description;
  private int edition;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public Date getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Date releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getEdition() {
    return edition;
  }

  public void setEdition(int edition) {
    this.edition = edition;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getCoverImage() {
    return coverImage;
  }

  public void setCoverImage(String coverImage) {
    this.coverImage = coverImage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getVolumeNumber() {
    return volumeNumber;
  }

  public void setVolumeNumber(int volumeNumber) {
    this.volumeNumber = volumeNumber;
  }

  public int getPagesCount() {
    return pagesCount;
  }

  public void setPagesCount(int pagesCount) {
    this.pagesCount = pagesCount;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public Book() {
    this.title = "this is a test title";
    this.author = "this is a test author";
  }

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }


  @Override
  public String toString() {
    return title + " " + author;
  }
}
