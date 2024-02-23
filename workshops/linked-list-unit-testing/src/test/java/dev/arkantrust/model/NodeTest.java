package dev.arkantrust.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    private Node node;

    /**
     * A node instance with id = ‘A0’
     */
    public void setupStage1() {

        node = new Node("A0");

    }

    /**
     * A node instance with id = ‘A0’ with a next node with id = ‘A1’
     */
    public void setupStage2() {

        node = new Node("A0");
        node.setNext(new Node("A1"));

    }

    @Test
    public void testGetId() {

        setupStage1();
        assertEquals("A0", node.getId());

    }

    @Test
    public void testgetNext() {

        setupStage2();
        String id = node.getNext().getId();
        assertEquals("A1", id);

    }

}
