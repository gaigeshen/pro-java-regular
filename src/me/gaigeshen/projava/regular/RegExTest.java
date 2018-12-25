package me.gaigeshen.projava.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 *
 * @author gaigeshen
 */
public class RegExTest {

  public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
  
  @Test
  public void test() throws Exception {
    System.out.println(EXAMPLE_TEST.matches("\\w.*")); // A word character, short for [a-zA-Z_0-9], Occurs zero or more times, is short for {0,}
    String[] splitStr = EXAMPLE_TEST.split("\\s+"); // A whitespace character, short for [ \t\n\x0b\r\f], Occurs one or more times, is short for {1,}
    for (String str : splitStr) {
      System.out.println(str);
    }
    System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t")); // Replace whitespace character to "tab"
  }
  
  @Test
  public void isTrue() throws Exception {
    System.out.println("true".matches("true"));
  }
  
  @Test
  public void isTrue2() throws Exception {
    System.out.println("true".matches("[tT]rue"));
    System.out.println("True".matches("[tT]rue"));
  }
  
  @Test
  public void isTrueOrYes() throws Exception {
    System.out.println("true".matches("[tT]rue|[yY]es"));
    System.out.println("True".matches("[tT]rue|[yY]es"));
    System.out.println("yes".matches("[tT]rue|[yY]es"));
    System.out.println("Yes".matches("[tT]rue|[yY]es"));
  }
  
  @Test
  public void containsTrue() throws Exception {
    System.out.println("111truebbbbaa".matches(".*true.*"));
  }
  
  @Test
  public void isThreeLetters() throws Exception {
    System.out.println("cdv".matches("[a-zA-Z]{3}"));
    System.out.println("cdv".matches("[a-Z][a-Z][a-Z]"));
  }
  
  @Test
  public void isNotNumberAtBeginning() throws Exception {
    System.out.println("v111".matches("^[^\\d].*"));
  }
  
  @Test
  public void patternTest() throws Exception {
    Pattern pattern = Pattern.compile("\\w+");
    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
    while (matcher.find()) {
      System.out.print("Start index: " + matcher.start());
      System.out.print(" End index: " + matcher.end() + " ");
      System.out.println(matcher.group());
    }
  }
}
