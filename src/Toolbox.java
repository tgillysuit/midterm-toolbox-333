import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
// Hey JARVIS complete the code!!! DONT TOUCH THIS, LEAVE ME ALONE :)
// Testing - Tav 
// Rebecca Riffle was here (veni, vidi, vici)
// Hello From Jameson
//Hi Jameson
//Raymond -Hello.n
public class Toolbox {
  // Augy was here
  // test - Tia
  // juno c:
  // Liza
  // Tyler Gilmore
  //Jonathan was here
  //AESPA TONIGHT!, im there after this, VIP

  //Rush B 
  // Alston Dsouza was not here
  // Diana is not here JOE MAMA!!
  // Auberon is the best!
  // Who's going for Costco IT, you
  /**
   * Removes an element from an array of strings at the specified index, padding with nulls at the end.
   *
   * @param array the array of strings to modify
   * @param index the index of the element to remove
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void removeElementInPlace(String[] array, int index) {
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }

    // for loop starting at a given index until arr.length - 1
    for (int i = 0; i < array.length - 1; i++) {
      // arr[i] = arr[i + 1]
      array[i] = array[i + 1];
      // arr.length - 1 = null
    }
    array[array.length - 1] = null;
  }

  /**
   * Adds an element to an array of strings at a specified location in-place, evicting the last value.
   *
   * @param array the array of strings to modify
   * @param index the index at which to add the new element
   * @param value the value to add
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void addElementInPlace(String[] array, int index, String value) {
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }
    array[index] = value; // FELIX :)
  }

  /**
   * Finds the tail of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list                                 
   * @return the tail node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode findTail(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    SingleNode current = head;
    while (current != null) {
      current = current.next;
    }
    return current;
  }

  /**
   * Finds the head of a doubly linked list given the tail.
   *
   * @param tail the tail node of the doubly linked list
   * @return the head node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the tail is null
   */
  public static DoubleNode findHead(DoubleNode tail) {
    if (tail == null) {
      throw new IllegalArgumentException("Tail cannot be null.");
    }
    
    DoubleNode current = tail;
    while(current != null){
      current = current.prev;
    }
    
    return current; 
  }

// Jesse Chum
//Hey Cortana solve this for me!
  /**
   * Counts the occurrences of values in a linked list.
   *
   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */

  public static Map<Integer, Integer> countOccurrences(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }

    Map<Integer, Integer> countMap = new HashMap<>();
    
    SingleNode current = head;
    while (current != null) {
      countMap.put(current.data, countMap.getOrDefault(current.data, 0) + 1);
      }
      current = current.next;
    return countMap;
  }

  /** 
   * Tyler Gilmore implemented
   * 
   * Removes a node from a doubly linked list.
   *
   * @param node the node to remove
   * @throws IllegalArgumentException if the node is null
   */
  public static void removeNode(DoubleNode node) {
    if (node == null) {
      throw new IllegalArgumentException("Node cannot be null.");
    }

    // link previous node to next
    if (node.prev != null) {
      node.prev.next = node.next;
    }

    // link next node to previous
    if (node.next != null) {
      node.next.prev = node.prev;
    }

    // to remove
    node.next = null;
    node.prev = null;
  }

  /**
   * Removes all odd values from a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @return the head of the modified list
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode removeOddValues(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    //Laura

    //Keep track of the nodes
    SingleNode current = head;
    SingleNode prev = null;
    
    //Start at 0
    int index = 0;
    while (current != null) {
        if (index % 2 != 0) {
            if (prev != null) {
                prev.next = current.next;
            }
        } 
        else {
            prev = current;
        }
      current = current.next;
      index++;
    }
    return head;
	  }
    
  /**
   * Finds the nth element in a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @param n the index of the element to find (0-based)
   * @return the nth node, or null if the index is out of bounds
   * @throws IllegalArgumentException if the head is null or n is negative
   */
  

  // Juno
  public static SingleNode findNthElement(SingleNode head, int n) {
    if (head == null || n < 0) {
      throw new IllegalArgumentException("Head cannot be null and n cannot be negative.");
    }
    SingleNode current = head;
    int index = 0;
    
    while ( current != null) {
      if (index == n) {
        return current; // This returns the nth node
      }
      current = current.next; // Move to the next node
      index++;
    }
  }

  /**
   * Inserts a new node into a singly linked list given a pointer to a node in the middle of the list.
   *
   * @param node the node before which the new node is to be inserted
   * @param newNode the new node to insert
   * @throws IllegalArgumentException if either node or newNode is null
 /   /**
  */
  public static void insertNode(SingleNode node, SingleNode newNode) {
    if (node == null || newNode == null) {
      throw new IllegalArgumentException("Node and newNode cannot be null.");
    }
    //Stephen
    newNode.next = node.next;
    node.next = newNode;
    
  }
  

  /**
   * Rotates a queue to the left by the specified number of positions in-place. 
   * 
   * The first k elements of the queue are moved to the end, preserving
    * of all elements.
   *
   * Example:
   * Given a queue [1, 2, 3, 4, 5] and k = 2, the result will be [3, 4, 5, 1, 2].
   *
   * @param queue the queue to rotate
   * @param k the number of positions to rotate to the left
   * @throws IllegalArgumentException if the queue is null or k is negative
   */
    public static void rotateQueueLeft(Queue<Integer> queue, int k) {

    if (queue == null || k < 0) {
      throw new IllegalArgumentException("Queue cannot be null and k cannot be negative.");
    }
    // Iterate through the queue to the specified index (k)
    for (int i = 0; i < k; i++) {
      // While iterating through, grab the value of the current index 
      //and move it to the end of the queue
      queue.add(queue.poll());
    }
  }

  /**
   * Checks if a string has balanced parentheses using a stack.
   * 
   * A string is considered to have balanced parentheses if each opening parenthesis
   * '(' has a corresponding closing parenthesis ')', and the parentheses are correctly nested.
   *
   * Example:
   * - Input: "(()())" -> Returns true
   * - Input: "(()" -> Returns false
   * - Input: ")" -> Returns false
   *
   * @param input the string to check
   * @return true if the string has balanced parentheses, false otherwise
   * @throws IllegalArgumentException if the input string is null
   */

  
  public static boolean hasBalancedParentheses(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }
    
  // Rebecca Riffle was here
  // forsan et haec olim meminisse iuvabit

  // Stack of opens
    Stack<Character> opens = new Stack<>();

    for (int index = 0; index < input.length() - 1; index++) {
      if (input.charAt(index) == '(') {
        char x = input.charAt(index);
        opens.push(x);
      }
      if (input.charAt(index) == ')') {
        if (opens.isEmpty()) {
          return false;
        } else {
          opens.pop();
        }
      }
      // when char at index is close, pop stack
    }
    
    if (opens.isEmpty()) {
        return true;
      }

      return false;
  }
}


      

    