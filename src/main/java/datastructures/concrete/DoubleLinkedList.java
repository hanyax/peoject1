package datastructures.concrete;

import datastructures.interfaces.IList;
import misc.exceptions.EmptyContainerException;
import misc.exceptions.NotYetImplementedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Note: For more info on the expected behavior of your methods, see
 * the source code for IList.
 */
public class DoubleLinkedList<T> implements IList<T> {
    // You may not rename these fields or change their types.
    // We will be inspecting these in our private tests.
    // You also may not add any additional fields.
    private Node<T> front;
    private Node<T> back;
    private int size;

    public DoubleLinkedList() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }
    
    /**
     * @modifies    this
     * @effect      add item to the end of list
     */
    @Override
    public void add(T item) {
        if (front == null) {
            front = new Node<T>(null, item, null);
            back = front;
        } else {
            Node<T> cur = back;
            cur.next = new Node<T>(cur, item, null);
            back = cur.next;
        }
        size++;
    }
    
    /**
     * @requires    this != empty
     * @modifies    this
     * @effect      remove the list element in the list
     * @return      the listnode that is removed
     * @throws      EmptyContainerException if there is no element in the list
     */
    @Override
    public T remove() {
        if (front == null) {
            throw new EmptyContainerException("container is empty and there is no element to remove");
        } else {
            size --;
            T removed = null;
            if (front.next == null) {
                removed = front.data;
                front = null;
                back = null;
            } else {
                removed = back.data;
                back = back.prev;
                back.next = null;
            }
            return removed;
        }
    }

    /**
     * @require index is in the range of list
     * @return the item at index
     * @throws IndexOutOfBoundsException if index is out of bounce
     */
    @Override
    public T get(int index) {
        
    }

    @Override
    public void set(int index, T item) {
        throw new NotYetImplementedException();
    }

    @Override
    public void insert(int index, T item) {
        throw new NotYetImplementedException();
    }

    @Override
    public T delete(int index) {
        throw new NotYetImplementedException();
    }

    @Override
    public int indexOf(T item) {
        throw new NotYetImplementedException();
    }
    
    /**
     * @return  size of the list
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T other) {
        throw new NotYetImplementedException();
    }

    @Override
    public Iterator<T> iterator() {
        // Note: we have provided a part of the implementation of
        // an iterator for you. You should complete the methods stubs
        // in the DoubleLinkedListIterator inner class at the bottom
        // of this file. You do not need to change this method.
        return new DoubleLinkedListIterator<>(this.front);
    }

    private static class Node<E> {
        // You may not change the fields in this node or add any new fields.
        public final E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(E data) {
            this(null, data, null);
        }

        // Feel free to add additional constructors or methods to this class.
    }

    private static class DoubleLinkedListIterator<T> implements Iterator<T> {
        // You should not need to change this field, or add any new fields.
        private Node<T> current;

        public DoubleLinkedListIterator(Node<T> current) {
            // You do not need to make any changes to this constructor.
            this.current = current;
        }

        /**
         * Returns 'true' if the iterator still has elements to look at;
         * returns 'false' otherwise.
         */
        public boolean hasNext() {
            throw new NotYetImplementedException();
        }

        /**
         * Returns the next item in the iteration and internally updates the
         * iterator to advance one element forward.
         *
         * @throws NoSuchElementException if we have reached the end of the iteration and
         *         there are no more elements to look at.
         */
        public T next() {
            throw new NotYetImplementedException();
        }
    }
}
