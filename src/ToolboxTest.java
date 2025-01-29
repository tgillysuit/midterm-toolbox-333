import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ToolboxTest {

    // ----------------------------------------------------------------------
    // removeElementInPlace(String[] array, int index)
    // ----------------------------------------------------------------------

    @Test
    void testRemoveElementInPlaceValidIndexMiddle() {
        String[] array = {"frog", "banana", "xylophone", "mug", "pear"};
        Toolbox.removeElementInPlace(array, 2);
        String[] expected = {"frog", "banana", "mug", "pear", null};
        assertArrayEquals(expected, array);
    }

    @Test
    void testRemoveElementInPlaceRemoveFirstElement() {
        String[] array = {"frog", "banana", "xylophone"};
        Toolbox.removeElementInPlace(array, 0);
        String[] expected = {"banana", "xylophone", null};
        assertArrayEquals(expected, array);
    }

    @Test
    void testRemoveElementInPlaceRemoveLastElement() {
        String[] array = {"frog", "banana", "xylophone"};
        Toolbox.removeElementInPlace(array, 2);
        String[] expected = {"frog", "banana", null};
        assertArrayEquals(expected, array);
    }

    @Test
    void testRemoveElementInPlaceNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.removeElementInPlace(null, 0);
        });
    }

    @Test
    void testRemoveElementInPlaceNegativeIndex() {
        String[] array = {"frog", "banana"};
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.removeElementInPlace(array, -1);
        });
    }

    @Test
    void testRemoveElementInPlaceIndexOutOfBounds() {
        String[] array = {"frog", "banana", "xylophone"};
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.removeElementInPlace(array, 3);
        });
    }

    // ----------------------------------------------------------------------
    // addElementInPlace(String[] array, int index, String value)
    // ----------------------------------------------------------------------

    @Test
    void testAddElementInPlaceValidIndexMiddle() {
        String[] array = {"cat", "orange", "hat", "door"};
        Toolbox.addElementInPlace(array, 2, "cloud");
        String[] expected = {"cat", "orange", "cloud", "hat"};
        assertArrayEquals(expected, array);
    }

    @Test
    void testAddElementInPlaceAddAtFirst() {
        String[] array = {"cat", "orange", "hat"};
        Toolbox.addElementInPlace(array, 0, "rain");
        // "hat" is evicted
        String[] expected = {"rain", "cat", "orange"};
        assertArrayEquals(expected, array);
    }

    @Test
    void testAddElementInPlaceAddAtLast() {
        String[] array = {"cat", "orange", "hat"};
        Toolbox.addElementInPlace(array, 2, "slate");
        // "hat" is evicted
        String[] expected = {"cat", "orange", "slate"};
        assertArrayEquals(expected, array);
    }

    @Test
    void testAddElementInPlaceNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.addElementInPlace(null, 0, "something");
        });
    }

    @Test
    void testAddElementInPlaceNegativeIndex() {
        String[] array = {"cat", "orange"};
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.addElementInPlace(array, -1, "test");
        });
    }

    @Test
    void testAddElementInPlaceIndexOutOfBounds() {
        String[] array = {"cat", "orange", "hat"};
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.addElementInPlace(array, 3, "oops");
        });
    }

    // ----------------------------------------------------------------------
    // findTail(SingleNode head)
    // ----------------------------------------------------------------------

    @Test
    void testFindTailMultipleElements() {
        // SLL: 19 -> 42 -> 7
        SingleNode head = new SingleNode(19, new SingleNode(42, new SingleNode(7)));
        SingleNode tail = Toolbox.findTail(head);
        assertNotNull(tail);
        assertEquals(7, tail.data);
        assertNull(tail.next);
    }

    @Test
    void testFindTailSingleElement() {
        SingleNode head = new SingleNode(500);
        SingleNode tail = Toolbox.findTail(head);
        assertEquals(head, tail);
        assertEquals(500, tail.data);
        assertNull(tail.next);
    }

    @Test
    void testFindTailNullHead() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.findTail(null);
        });
    }

    // ----------------------------------------------------------------------
    // findHead(DoubleNode tail)
    // ----------------------------------------------------------------------

    @Test
    void testFindHeadMultipleElements() {
        // DLL: 27 <-> 11 <-> 83
        DoubleNode n1 = new DoubleNode(27);
        DoubleNode n2 = new DoubleNode(11);
        DoubleNode n3 = new DoubleNode(83);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;

        DoubleNode head = Toolbox.findHead(n3);
        assertEquals(n1, head);
        assertNull(head.prev);
    }

    @Test
    void testFindHeadSingleElement() {
        DoubleNode tail = new DoubleNode(999);
        DoubleNode head = Toolbox.findHead(tail);
        assertEquals(tail, head);
        assertEquals(999, head.data);
        assertNull(head.prev);
        assertNull(head.next);
    }

    @Test
    void testFindHeadNullTail() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.findHead(null);
        });
    }

    // ----------------------------------------------------------------------
    // countOccurrences(SingleNode head)
    // ----------------------------------------------------------------------

    @Test
    void testCountOccurrencesMultiple() {
        // SLL: 5 -> 12 -> 5 -> 3 -> 5 -> 12
        SingleNode head = SingleNode.fromList(Arrays.asList(5, 12, 5, 3, 5, 12));
        Map<Integer, Integer> counts = Toolbox.countOccurrences(head);
        // Expect {5=3, 12=2, 3=1}
        assertEquals(3, counts.size());
        assertEquals(Integer.valueOf(3), counts.get(5));
        assertEquals(Integer.valueOf(2), counts.get(12));
        assertEquals(Integer.valueOf(1), counts.get(3));
    }

    @Test
    void testCountOccurrencesSingleElement() {
        SingleNode head = new SingleNode(66);
        Map<Integer, Integer> counts = Toolbox.countOccurrences(head);
        // Expect {66=1}
        assertEquals(1, counts.size());
        assertEquals(Integer.valueOf(1), counts.get(66));
    }

    @Test
    void testCountOccurrencesNullHead() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.countOccurrences(null);
        });
    }

    // ----------------------------------------------------------------------
    // removeNode(DoubleNode node)
    // ----------------------------------------------------------------------

    @Test
    void testRemoveNodeMiddle() {
        // DLL: 8 <-> 99 <-> 13 <-> 23
        DoubleNode n1 = new DoubleNode(8);
        DoubleNode n2 = new DoubleNode(99);
        DoubleNode n3 = new DoubleNode(13);
        DoubleNode n4 = new DoubleNode(23);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        Toolbox.removeNode(n2);
        // Expected: 8 <-> 13 <-> 23
        assertEquals(n1, n3.prev);
        assertEquals(n3, n1.next);
        assertEquals(n4, n3.next);
        assertEquals(n3, n4.prev);
    }

    @Test
    void testRemoveNodeFirst() {
        // DLL: 8 <-> 99
        DoubleNode n1 = new DoubleNode(8);
        DoubleNode n2 = new DoubleNode(99);
        n1.next = n2; n2.prev = n1;

        Toolbox.removeNode(n1);
        // Expected: just n2 left
        assertNull(n2.prev);
        assertNull(n2.next);
    }

    @Test
    void testRemoveNodeLast() {
        // DLL: 8 <-> 99
        DoubleNode n1 = new DoubleNode(8);
        DoubleNode n2 = new DoubleNode(99);
        n1.next = n2; n2.prev = n1;

        Toolbox.removeNode(n2);
        // Expected: just n1 left
        assertNull(n1.next);
        assertNull(n1.prev);
    }

    @Test
    void testRemoveNodeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.removeNode(null);
        });
    }

    // ----------------------------------------------------------------------
    // findNthElement(SingleNode head, int n)
    // ----------------------------------------------------------------------

    @Test
    void testFindNthElementValidIndex() {
        // SLL: 7 -> 19 -> 3 -> 4
        SingleNode head = SingleNode.fromList(Arrays.asList(7, 19, 3, 4));
        SingleNode result = Toolbox.findNthElement(head, 1);
        // Expected node with data=19
        assertNotNull(result);
        assertEquals(19, result.data);
    }

    @Test
    void testFindNthElementLastIndex() {
        // SLL: 7 -> 19 -> 3 -> 4
        SingleNode head = SingleNode.fromList(Arrays.asList(7, 19, 3, 4));
        SingleNode result = Toolbox.findNthElement(head, 3);
        // Expected node with data=4
        assertNotNull(result);
        assertEquals(4, result.data);
    }

    @Test
    void testFindNthElementOutOfBounds() {
        SingleNode head = SingleNode.fromList(Arrays.asList(10, 5));
        SingleNode result = Toolbox.findNthElement(head, 5);
        // Expected: null
        assertNull(result);
    }

    @Test
    void testFindNthElementNullHead() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.findNthElement(null, 0);
        });
    }

    @Test
    void testFindNthElementNegativeIndex() {
        SingleNode head = new SingleNode(1);
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.findNthElement(head, -1);
        });
    }

    // ----------------------------------------------------------------------
    // insertNode(SingleNode node, SingleNode newNode)
    // ----------------------------------------------------------------------

    @Test
    void testInsertNodeInMiddle() {
        // SLL: 10 -> 5 -> 19
        SingleNode head = SingleNode.fromList(Arrays.asList(10, 5, 19));
        SingleNode node = head.next; // data=5
        SingleNode newNode = new SingleNode(7);

        Toolbox.insertNode(node, newNode);
        // Expected: 10 -> 5 -> 7 -> 19
        assertEquals(Arrays.asList(10, 5, 7, 19), head.toList());
    }

    @Test
    void testInsertNodeAfterLast() {
        // SLL: 10 -> 5
        SingleNode head = SingleNode.fromList(Arrays.asList(10, 5));
        SingleNode lastNode = head.next; // data=5
        SingleNode newNode = new SingleNode(33);

        Toolbox.insertNode(lastNode, newNode);
        // Expected: 10 -> 5 -> 33
        assertEquals(Arrays.asList(10, 5, 33), head.toList());
    }

    @Test
    void testInsertNodeNullNode() {
        SingleNode newNode = new SingleNode(5);
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.insertNode(null, newNode);
        });
    }

    @Test
    void testInsertNodeNullNewNode() {
        SingleNode head = new SingleNode(1);
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.insertNode(head, null);
        });
    }

    // ----------------------------------------------------------------------
    // rotateQueueLeft(Queue<Integer> queue, int k)
    // ----------------------------------------------------------------------

    @Test
    void testRotateQueueLeftValid() {
        // queue: [3, 9, 1, 14, 8]
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(3, 9, 1, 14, 8));
        Toolbox.rotateQueueLeft(queue, 2);
        // Expected: [1, 14, 8, 3, 9]
        assertEquals(Arrays.asList(1, 14, 8, 3, 9), new ArrayList<>(queue));
    }

    @Test
    void testRotateQueueLeftZero() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 25, 7));
        Toolbox.rotateQueueLeft(queue, 0);
        // Expected: [10, 25, 7] (unchanged)
        assertEquals(Arrays.asList(10, 25, 7), new ArrayList<>(queue));
    }

    @Test
    void testRotateQueueLeftLargeK() {
        // queue: [3, 9, 1, 14, 8]
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(3, 9, 1, 14, 8));
        // Rotating by 7 is the same as rotating by 2 if size=5
        Toolbox.rotateQueueLeft(queue, 7);
        // Expected: [1, 14, 8, 3, 9]
        assertEquals(Arrays.asList(1, 14, 8, 3, 9), new ArrayList<>(queue));
    }

    @Test
    void testRotateQueueLeftNullQueue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.rotateQueueLeft(null, 2);
        });
    }

    @Test
    void testRotateQueueLeftNegativeK() {
        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.rotateQueueLeft(queue, -1);
        });
    }

    // ----------------------------------------------------------------------
    // hasBalancedParentheses(String input)
    // ----------------------------------------------------------------------

    @Test
    void testHasBalancedParenthesesBalanced() {
        assertTrue(Toolbox.hasBalancedParentheses("(()())"));
    }

    @Test
    void testHasBalancedParenthesesUnmatched() {
        assertFalse(Toolbox.hasBalancedParentheses("(()"));
        assertFalse(Toolbox.hasBalancedParentheses("())"));
    }

    @Test
    void testHasBalancedParenthesesMismatch() {
        assertFalse(Toolbox.hasBalancedParentheses(")("));
    }

    @Test
    void testHasBalancedParenthesesEmptyString() {
        assertTrue(Toolbox.hasBalancedParentheses(""));
    }

    @Test
    void testHasBalancedParenthesesNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            Toolbox.hasBalancedParentheses(null);
        });
    }
}
