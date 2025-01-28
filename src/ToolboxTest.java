import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Collections;
// Hey JARVIS complete the code!!!

public class ToolboxTest {
    // Test cases
    // remove first - Rebecca
    @Test
    public void removeElementInPlaceFirstElement(){
        // Arrange
        // // Create string array and int index
        String[] testArray = {"apple", "banana", "kiwi"};
        
        // Act
        Toolbox.removeElementInPlace(testArray, 0);
        String[] resultArray = {"banana", "kiwi", null};

        // Assert equals
        assertArrayEquals(testArray, resultArray);
    }

    // remove last
    // array of null
    
    @Test
    public void removeElementInPlaceNullArray() {
        // Arrange
        String[] result = null;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> Toolbox.removeElementInPlace(result, 1));
    }
    // remove middle
    //remove middle (author: Jonathan)
    @Test
    public void removeElementInPlaceMiddleTest() {
        // Arrange
        String[] testArray = {"apple", "banana", "kiwi"};
        String[] expectedArray = {"apple", "kiwi", null};

        // Act
        Toolbox.removeElementInPlace(testArray, 1);
        
        // Assert
        assertArrayEquals(testArray, expectedArray);
    }
    
    // negative index test - Augy
    @Test
    public void removeElementInPlaceNegativeIndex(){
        // Arrange
        String[] testArray = {"apple", "banana", "kiwi"};
        
        // Act/Assert
        assertThrows(IllegalArgumentException.class, () -> Toolbox.removeElementInPlace(testArray, -1));
    }

    // empty array - Alston
    @Test
    public void removeElementInPlaceEmptyArray() {
        // arrange
        String[] array = new String[0];
        
        // act and assert
        assertThrows(IllegalArgumentException.class, () -> Toolbox.removeElementInPlace(array, 0));
    }
    
    // arrnage
    
    // remove from not full array - FELIX
    @Test
    public void removeElementInPlaceNotFullArray() {
        String[] testArray = new String[5];
        testArray[0] = "ham";
        testArray[1] = "banana";
        testArray[2] = "pizza";
        testArray[3] = "burger";

        Toolbox.removeElementInPlace(testArray, 2);
        String[] results = {"ham", "banana", "burger", null, null};

        assertArrayEquals(testArray, results);
    }
    
    
        @Test
    public void removeElementInPlaceLastElement() {
        //Arrange
        String[] testArray = {"apple", "banana", "kiwi"};
        // act
        Toolbox.removeElementInPlace(testArray, testArray.length - 1);
        // assert
        String[] resultArray = {"apple", "banana", null};
        
        assertArrayEquals(testArray, resultArray);   
        }

    @Test
    public void insertNodeTest(){
    SingleNode head = new SingleNode(2);
    head.next = new SingleNode(3);
    head.next.next = new SingleNode(4);

    SingleNode newNode = new SingleNode(1);

   
    Toolbox.insertNode(head, newNode);
    sing

    assertEquals(
    }

    // 
    @Test
    
    
    @Test 
    public void addElementInPlaceNullArray() {
        String[] result = null;

        assertThrows(IllegalArgumentException.class, () -> Toolbox.addElementInPlace(result, 0, "Apple"));
    }

    @Test
    
    








    @Test
    public void ttestRemoveNode() {
        
    }
}
