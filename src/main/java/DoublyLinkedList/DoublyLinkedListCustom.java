package DoublyLinkedList;

import java.util.Random;

public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;
    private int size;


    @Override
    public void addFirst(int item) {
        // addFirst
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(int item) {
        // addLast
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addAtIndex(int index, int item) {
        // addAtIndex
        if (index < 0 || index > size) {
            throwIllegal();
        } else if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            size++;
        }
    }

    @Override
    public void addElementAtRandomIndex(int item) {
        // addElementAtRandomIndex
        Random rand = new Random();
        int index = rand.nextInt(0, size + 1);
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            size++;
        }
    }

    @Override
    public Node removeFirst() {
        //removeFirst
        if (isEmpty()) {
            throwIllegal();
        }
        Node temp = head;
        if (head.getNext() == null) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return temp;
    }

    @Override
    public Node removeLast() {
        // removeLast
        if (isEmpty()) {
            throwIllegal();
        }

        Node temp = tail;
        if (head.getNext() == null) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            tail = current.getPrevious();
            tail.setNext(null);
        }
        size--;
        return temp;
    }

    @Override
    public Node removeAtIndex(int index) {
        // removeAtIndex
        if (isEmpty()) {
            throwIllegal();
        } else if (index < 0 || index >= size) {
            throwIllegal();
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        size--;
        return current;
    }

    @Override
    public int getSize() {
        // getSize
        return size;
    }

    @Override
    public boolean isEmpty() {
        //isEmpty
        return head == null;
    }

    @Override
    public void printList() {
        // printList
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" <--> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public void printListBackwards() {
        // printListBackwards
        Node current = tail;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getPrevious() != null) {
                System.out.print(" <--> ");
            }
            current = current.getPrevious();
        }
        System.out.println();
    }

    @Override
    public int get(int index) throws IllegalArgumentException {
        //Done ???
        if (isEmpty() || index < 0 || index >= size) {
            throwIllegal();
        }

        Node current = head;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                break;
            }
            current = current.getNext();
        }

        return current.getValue();
    }

    @Override
    public void removeDuplicates() {
        // removeDuplicates
        if (isEmpty()) {
            //do nothing
        } else {
            Node current = head;
            while (current.getNext() != null) {
                int index = 0;
                int currentValue = current.getValue();

                Node current2 = current;
                while (current2.getNext() != null) {
                    if (currentValue == current2.getNext().getValue()) {
                        removeAtIndex(index + 1);
                    }
                    index++;
                    current2 = current2.getNext();
                }
                current = current.getNext();
            }
        }

    }

    @Override
    public void reverseList() {
        // reverseList
        if (isEmpty()) {
            throwIllegal();
        }

        Node oldHead = head;
        Node current = tail;
        head = tail;
        while (current != null) {
            Node temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = temp;
        }
        tail = oldHead;
    }

    @Override
    public DoublyLinkedListCustom copyList() {
        // copyList
        DoublyLinkedListCustom returnList = new DoublyLinkedListCustom();

        Node current = head;
        while (current.getNext() != null) {
            returnList.addLast(current.getValue());
            current = current.getNext();
        }
        return returnList;
    }

    @Override
    public void clear() {
        // clear
        head = tail = null;
    }

    @Override
    public boolean insertAfter(int index, int data) {
        // insertAfter
        if (index < 0 || index >= size) {
            return false;
        } else if (isEmpty()) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        } else {
            Node newNode = new Node(data);

            Node current = head;
            for (int i = 0; i <= index; i++) {
                current = current.getNext();
            }

            current.getPrevious().setNext(newNode);
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            size++;
        }
        return true;
    }

    @Override
    public Node deleteKey(int index) {
        // deleteKey
        if (isEmpty()) {
            throwIllegal();
        } else if (index < 0 || index >= size) {
            throwIllegal();
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        size--;
        return current;
    }

    private void throwIllegal() {
        throw new IllegalArgumentException("Input out of bounds");
    }
}