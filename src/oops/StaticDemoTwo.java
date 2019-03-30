package oops;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/03/19
 * Time:    1:47 PM
 */
public class StaticDemoTwo extends  StaticDemo {

  public static void methodOne() {
    System.out.println("From subclass");
  }

  public static void main(String[] args) {
    StaticDemo s = new StaticDemoTwo();
    s.methodOne();
  }
}
