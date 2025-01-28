/**
 * Represents a node in a doubly linked list.
 * Each node stores an integer value and has references to the next and previous nodes in the list.
 */
public class DoubleNode {

  /**
   * The data stored in this node.
   */
  public int data;

  /**
   * The reference to the next node in the doubly linked list.
   * If this is the last node in the list, next is null.
   */
  public DoubleNode next;

  /**
   * The reference to the previous node in the doubly linked list.
   * If this is the first node in the list, prev is null.
   */
  public DoubleNode prev;

  /**
   * Constructs a DoubleNode with the specified data and a reference to the next node.
   * The prev reference is initialized to null.
   *
   * @param data the integer value to store in this node
   * @param next the next node in the list, or null if this is the last node
   */
  public DoubleNode(int data, DoubleNode next) {
    this.data = data;
    this.next = next;
    // prev is null by default
  }

  /**
   * Constructs a DoubleNode with the specified data.
   * The next and prev references are initialized to null.
   *
   * @param data the integer value to store in this node
   */
  public DoubleNode(int data) {
    this(data, null);
  }
}
