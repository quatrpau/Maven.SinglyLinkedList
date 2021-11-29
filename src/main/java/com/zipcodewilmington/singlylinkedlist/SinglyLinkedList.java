package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable<E>>{
    //always add thing to end
    Node<E> head; //head is the top of the straight
    Node<E> tail;//tail is the exposed node
    int size = 0;
    public SinglyLinkedList(Node<E> head){
        if(head == null){
            System.out.println("null head");
        }
        else if(head.next == null) {
            this.head = head;
            size++;
            this.tail = head;
            this.head.index = 0;
        }
        else{
            addMultipleNodes(head);
            this.head = head;
        }
    }
    public Node<E> getHead(){
        return this.head;
    }
    public Node<E> getTail(){ //this is the end of the sequence
        return this.tail;
    }
    private void addMultipleNodes(Node<E> newbies){ //add to tailV //double check indices
        Node<E> temp = newbies;
        if(tail != null){
            tail.next = newbies;
        }
        else if(head == null) {
            head = newbies;
        }
        while(temp.next != null){
            temp.setIndex(size);
            size++;
            temp = temp.next;
        }
        this.tail = temp;
        this.tail.setIndex(size);
        size++;
    }
    public void addNode(Node<E> newbie){ //add to tailV
        if(newbie == null) {
            System.out.println("parameter is null");
        }
        else if(newbie.next == null) {
            if (tail == null) {
                head = newbie;
            } else {
                tail.next = newbie;
            }
            this.tail = newbie;
            this.tail.setIndex(size);
            size++;
        }
        else {
            this.addMultipleNodes(newbie);
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int getSize(){
        return size;
    }
    public Node<E> removeNode(Node<E> nodeToRemove){
        Node<E> curr = this.head;
        Node<E> prev = curr;
        if(new SinglyLinkedList<E>(nodeToRemove).equals(this) && nodeToRemove.next == null){
            tail = null;
            head = null;
            size = 0;
            return curr;
        }
        size = 0;
        while(!curr.equals(nodeToRemove)){
            size++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return curr;
    }
    public boolean contains(Node<E> nodeToFind){
        return this.findNode(nodeToFind) != -1;
    }
    public int findNode(Node<E> nodeToFind){
        if(nodeToFind == null){
            return -1;
        }
        Node<E> curr = this.head;
        while(!curr.equals(nodeToFind) && curr.next != null){
            curr = curr.next;
        }
        if(curr.equals(nodeToFind)){
            return curr.getIndex();
        }
        return -1;
    }
    public Node<E> getNode(int index){
        Node<E> curr = this.head;
        while(curr.getIndex() != curr.getIndex()){
            curr = curr.next;
        }
        return curr;
    }
    public SinglyLinkedList<E> copy(){
        return new SinglyLinkedList<E>(head);
    }
    //compares via comparator
    public SinglyLinkedList<E> selectionSort() {
        SinglyLinkedList<E> sorted = new SinglyLinkedList<E>(null);
        SinglyLinkedList<E> arraycopy = this.copy();
        Node<E> curr = arraycopy.getHead();
        int sortCurs = 0;
        if(this.size == 1) {
            return this;
        }
        Node<E> smallest = arraycopy.getHead();
        while(sortCurs < this.size){
            while(curr.next != null) {
                if(curr.compareTo(smallest) >= 0){
                    smallest = curr;
                }
                curr = curr.getNext();
            }
            arraycopy.removeNode(smallest);
            sorted.addNode(smallest);
            smallest = arraycopy.getHead();
            curr = arraycopy.getHead();
            sortCurs++;
        }
        return sorted;
        //find smallest
        //place it at the begininning
        //find second smallest
        //place it next
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList<?> olist = (SinglyLinkedList<?>) o;
        if (olist.size != this.size) return false;
        Node<E> tempt = this.head; //temp this
        Node<?> tempo = olist.head; //temp olist
        while(tempt.next != null){
            if(!tempt.value.equals(tempo.value)){
                return false;
            }
            tempt = tempt.next;
            tempo = tempo.next;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            return "";
        }
        Node<E> temp = this.head;
        while(temp != null){
            sb.append(temp);
            temp = temp.next;
            sb.append(",");
        }
        return sb.toString();
    }

}

