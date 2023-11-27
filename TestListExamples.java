import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testFilter_AllStringsValid() {
    List<String> inputList = Arrays.asList("apple", "banana", "cherry");
    StringChecker sc = s -> true; 
    List<String> filteredList = ListExamples.filter(inputList, sc);
    assertEquals(Arrays.asList("apple", "banana", "cherry"), filteredList);
  }

  @Test
  public void testFilter_NoStringsValid() {
    List<String> inputList = Arrays.asList("apple", "banana", "cherry");
    StringChecker sc = s -> false; 
    List<String> filteredList = ListExamples.filter(inputList, sc);
    assertTrue(filteredList.isEmpty());
  }

  @Test
  public void testFilter_SomeStringsValid() {
    List<String> inputList = Arrays.asList("apple", "banana", "cherry");
    StringChecker sc = s -> s.startsWith("a"); 
    List<String> filteredList = ListExamples.filter(inputList, sc);
    assertEquals(Arrays.asList("apple"), filteredList);
  }

  @Test
  public void testFilter_EmptyList() {
    List<String> inputList = Arrays.asList();
    StringChecker sc = s -> true;
    List<String> filteredList = ListExamples.filter(inputList, sc);
    assertTrue(filteredList.isEmpty());
  }

    @Test
    public void testMerge_BothListsEmpty() {
      List<String> list1 = Arrays.asList();
      List<String> list2 = Arrays.asList();
      List<String> result = ListExamples.merge(list1, list2);
      assertTrue(result.isEmpty());
    }

    @Test
    public void testMerge_FirstListEmpty() {
      List<String> list1 = Arrays.asList();
      List<String> list2 = Arrays.asList("apple", "banana");
      List<String> result = ListExamples.merge(list1, list2);
      assertEquals(Arrays.asList("apple", "banana"), result);
    }

    @Test
    public void testMerge_SecondListEmpty() {
      List<String> list1 = Arrays.asList("apple", "banana");
      List<String> list2 = Arrays.asList();
      List<String> result = ListExamples.merge(list1, list2);
      assertEquals(Arrays.asList("apple", "banana"), result);
    }

    @Test
    public void testMerge_BothListsNonEmpty() {
      List<String> list1 = Arrays.asList("apple", "cherry");
      List<String> list2 = Arrays.asList("banana", "date");
      List<String> result = ListExamples.merge(list1, list2);
      assertEquals(Arrays.asList("apple", "banana", "cherry", "date"), result);
    }

    @Test
    public void testMerge_WithDuplicateStrings() {
      List<String> list1 = Arrays.asList("apple", "banana");
      List<String> list2 = Arrays.asList("banana", "cherry");
      List<String> result = ListExamples.merge(list1, list2);
      assertEquals(Arrays.asList("apple", "banana", "banana", "cherry"), result);
    }

    @Test
    public void testMerge_WithAllDuplicates() {
      List<String> list1 = Arrays.asList("apple", "apple");
      List<String> list2 = Arrays.asList("apple", "apple");
      List<String> result = ListExamples.merge(list1, list2);
      assertEquals(Arrays.asList("apple", "apple", "apple", "apple"), result);
    }
}
