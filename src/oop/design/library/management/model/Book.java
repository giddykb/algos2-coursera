package oop.design.library.management.model;

import com.peace.dp.LIS;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    12/04/19
 * Time:    3:12 PM
 */
@Getter
@Setter
public abstract class Book {

  private String ISBN;
  private String title;
  private List<String> authors;
  private String description;
  private String genre;
  private int totalPages;
  private String publisher;
  private String language;

}
