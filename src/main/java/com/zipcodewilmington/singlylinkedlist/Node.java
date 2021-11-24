package com.zipcodewilmington.singlylinkedlist;

//why must i use extends here
public class Node<E extends Comparable<E>>
        implements Comparable<Node<E>> {
    E value;
    Node<E> next;
    int index;
    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
        index = -1;
    }
    public E getValue(){
        return this.value;
    }

    public int compareTo(Node<E> other) {
        return (this.value).compareTo(other.getValue());
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return this.value.equals(node.value);
    }
    @Override
    public String toString(){
        return this.value.toString();
    }

    public Node<E> getNext() {
        return this.next;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
}