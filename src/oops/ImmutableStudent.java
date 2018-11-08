package oops;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    20/07/18
 * Time:    2:21 PM
 */
public final class ImmutableStudent {

  private  int id;
  private  String name;
  private Age age;

  ImmutableStudent(int id, String name, Age age){
    this.id = id;
    this.name = name;
    Age clone = new Age();
    clone.setDay(1);
    clone.setMonth(8);
    clone.setYear(1989);
    this.age = clone;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Age getAge() {
    return age;
  }


  public static void main(String[] args) {
    Age age = new Age();
    age.setDay(01);age.setMonth(6); age.setYear(1988);
    ImmutableStudent s = new ImmutableStudent(1,"girish",age);
    System.out.println("Age is " + age.getYear());
    s.getAge().setYear(1989);
    System.out.println("Age is " + age.getYear());
  }

  }
