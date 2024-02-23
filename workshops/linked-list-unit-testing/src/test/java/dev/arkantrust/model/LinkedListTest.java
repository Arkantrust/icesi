package dev.arkantrust.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList list;

    /**
     * A linkedList instance without nodes
     */
    public void setupStage1() {

        list = new LinkedList();

    }

    /**
     * A LinkedList instance with only one node added, with id = ‘A0’
     */
    public void setupStage2() {

        list = new LinkedList();
        list.addNode("A0");

    }

    /**
     * A LinkedList instance with 3 nodes added, with ids = ‘A0’, ‘A1’ and ‘A2’
     */
    public void setupStage3() {

        list = new LinkedList();
        list.addNode("A0");
        list.addNode("A1");
        list.addNode("A2");

    }

    // addNode

    /**
     * Test adding a node to an empty list.
     * <br>
     * </br>
     * The first node of the list should not be null.
     */
    @Test
    public void testAddNodeEmptyList() {

        setupStage1();
        list.addNode("A0");
        assertNotNull(list.getFirst());

    }

    /**
     * A new node is added to the list.
     * <br>
     * </br>
     * The last node's id should be "A4"
     */
    @Test
    public void testAddNode() {

        setupStage2();
        list.addNode("A4");

        // get the last element
        Node head = list.getFirst();
        while (head.getNext() != null) {
            head = head.getNext();
        }

        assertEquals("A4", head.getId());

    }

    // search

    /**
     * Test searching for a node in an empty list.
     * <br>
     * </br>
     * The result should be null.
     */
    @Test
    public void testSearchEmptyList() {

        setupStage1();
        Node result = list.search("A0");
        assertNull(result);

    }

    /**
     * Test searching for node with id = "A0".
     * <br>
     * </br>
     * The result should be a node with id = "A0".
     */
    @Test
    public void testSearch() {

        setupStage2();
        Node result = list.search("A0");
        assertEquals("A0", result.getId());

    }

    /**
     * Test searching for a node that doesn't exist in a list.
     * <br>
     * </br>
     * The result should be null.
     */
    @Test
    public void testSearchNonExistant() {

        setupStage2();
        Node result = list.search("A2");
        assertNull(result);

    }

    /**
     * Test searching for node with id = "A2".
     * <br>
     * </br>
     * The result should be a node with id = "A2".
     */
    @Test
    public void testSearchLongList() {

        setupStage3();
        Node result = list.search("A2");
        assertEquals("A2", result.getId());

    }

    // remove

    /**
     * Test removing the first element from a list.
     * <br>
     * </br>
     * The first element should be null.
     */
    @Test
    public void testRemove() {

        setupStage2();
        list.remove("A0");
        assertNull(list.getFirst());

    }

    /**
     * Test removing the first element from a list.
     * <br>
     * </br>
     * The first element should have id = "A1".
     */
    @Test
    public void testRemoveLongList() {

        setupStage3();
        list.remove("A0");
        assertEquals("A1", list.getFirst().getId());

    }

    /**
     * Test removing the last element from a list.
     * <br>
     * </br>
     * The last element should now have id = "A1".
     */
    @Test
    public void testRemoveLast() {

        setupStage3();
        list.remove("A2");

        // get the last element
        Node head = list.getFirst();
        while (head.getNext() != null) {
            head = head.getNext();
        }

        assertEquals("A1", head.getId());

    }

}
