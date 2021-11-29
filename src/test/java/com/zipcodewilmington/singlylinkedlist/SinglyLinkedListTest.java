package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> list;
    private Node<Integer> node;
    @Before
    public void before(){
        node = new Node<Integer>(2,new Node<Integer>(1,new Node<Integer>(4,new Node<Integer>(3,null))));
        list = new SinglyLinkedList<Integer>(node);
    }
    @Test
    public void addTest(){
        before();
        Node<Integer> newbie = new Node<Integer>(5,null);
        list.addNode(newbie);
        Assert.assertEquals(newbie,list.getTail());
    }
    @Test
    public void removeTest(){
        before();
        Node<Integer> newbie = new Node<Integer>(5,null);
        list.addNode(newbie);
        list.removeNode(newbie);
        Assert.assertEquals(list.findNode(newbie),-1);
    }
    @Test
    public void containsTest(){
        before();
        Assert.assertTrue(list.contains(new Node<Integer> (1,null)));
    }
    @Test
    public void findTest(){
        before();
        Assert.assertEquals(0,list.findNode(new Node<Integer>(2,null)));
    }
    @Test
    public void sizeTest(){
        before();
        Assert.assertEquals(4,list.size);
    }
    @Test
    public void getTest(){
        before();
        Node<Integer> newbie = new Node<Integer>(5,null);
        list.addNode(newbie);
        Assert.assertEquals(newbie,list.getNode(4));
    }
}
