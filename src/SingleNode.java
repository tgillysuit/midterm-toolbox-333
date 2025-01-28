/**
 * Represents a node in a singly linked list.
 * Each node contains an integer value and a reference to the next node in the list.
 */
public class SingleNode {

  /**
   * The integer value stored in this node.
   */
  public int data;

  /**
   * A reference to the next node in the singly linked list.
   * This is null if there is no next node.
   */
  public SingleNode next;

  /**
   * Constructs a SingleNode with the specified data and a reference to the next node.
   *
   * @param data the integer value to store in this node
   * @param next the next node in the list, or null if there is no next node
   */
  public SingleNode(int data, SingleNode next) {
    this.data = data;
    this.next = next;
  }

  /**
   * Constructs a SingleNode with the specified data.
   * The next reference is initialized to null.
   *
   * @param data the integer value to store in this node
   */
  public SingleNode(int data) {
    this(data, null);
  }
}
