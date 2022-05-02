package DoublyLinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();
        //TODO test all methods
        // don't forget to also check the head and tail references

        int item = 15;
        int myIndex = 5;
        int myElement = 25;
        int duplicate = 5;

        // isEmpty ==> true
        System.out.println("isEmpty: " + list.isEmpty());

        for (int i = 1; i < 11; i++) {
            list.addLast(i);
        }
        System.out.println("isEmpty: " + list.isEmpty());

        // printList & printListBackwards
        System.out.println("printList & printListBackwards");
        list.printList();
        list.printListBackwards();

        // getSize ==> 10
        System.out.println("get (5) & getSize ==> 10");
        System.out.println(list.get(myIndex));
        System.out.println(list.getSize());

        // addFirst & removeFirst
        System.out.println("addFirst & removeFirst");
        list.addFirst(item);
        list.printList();
        list.removeFirst();
        list.printList();

        // addAtIndex & removeAtIndex
        System.out.println("addAtIndex 5 & removeAtIndex 5 ==> 15");
        list.addAtIndex(myIndex, item);
        list.printList();
        list.removeAtIndex(myIndex);
        list.printList();

        // addLast & removeLast
        System.out.println("addLast & removeLast");
        list.addLast(item);
        list.printList();
        list.removeLast();
        list.printList();

        // removeDuplicates
        System.out.println("add and then removeDuplicates");
        list.addFirst(duplicate);
        list.addLast(duplicate);
        list.addAtIndex(5, duplicate);
        list.printList();
        list.removeDuplicates();
        list.printList();

        // reverseList & insertAfter
        System.out.println("reverseList & insert 100 after 4");
        list.reverseList();
        System.out.println(list.insertAfter(4,100));
        list.printList();

        // copyList & clear
        System.out.println("copyList, print list1 + list2, clear print list2");
        DoublyLinkedListCustom list2 = list.copyList();
        list.printList();
        list2.printList();
        list2.clear();
        list2.printList();
        System.out.println("list2 printed.");

        // deleteKey
        System.out.println("addElementAtRandomIndex & deleteKey: " + item);
        list.addElementAtRandomIndex(item);
        list.printList();
        list.deleteKey(item);
        list.printList();
    }
}