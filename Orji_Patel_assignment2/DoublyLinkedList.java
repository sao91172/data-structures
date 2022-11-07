package Orji_Patel_assignment2;

public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    private int length;

    public void deleteItem(T item) {

        if (this.getLength() == 0) {
            // this.head = node;

            System.out.println("\nYou cannot delete from an empty list");
            return;
        }

        NodeType<T> node = new NodeType<>(item);
        // node.setNext(null);
        node.info = item;

        NodeType<T> prevlocation = head;
        NodeType<T> location = head.next;

        // if deleting when the list is empty

        // if deleting the only item in list
        // System.out.print("head" + head.info);
        if (item.compareTo(head.info) == 0 && (this.getLength() == 1)) {
            this.head = null;
            // location = null;
            length--;
            return;
        } // if
          // if deleting at the beginning of the list
        if (item.compareTo(head.info) == 0) {
            head = head.next;
            length--;
            return;
        } else {

            // searching through the list
            while (location != null && location.info.compareTo(item) != 0) {
                if (location != null && location.info.compareTo(item) == 0) {
                    // debug:System.out.println("break");
                    // location.back = node;
                    break;
                } // if
                  // debug:System.out.println("point reached");
                  // shift
                prevlocation = location;
                location = location.next;
            } // while
            if (location == null) {
                System.out.println("\nThe item is not present in the list");
                return;
            }
            // deleting part
            prevlocation.next = location.next;
            location.next.back = location.back;
            location.back.next = location.next;

            length--;
        } // else

        return;
    }// deleteItem

    public void insertItem(T item) {
        NodeType<T> node = new NodeType<>(item);
        node.next = null;
        node.info = item;
        // node.next = head;
        node.back = null;

        NodeType<T> prevlocation = null;
        NodeType<T> location = head;

        // if inserting when the list is empty
        if (getLength() == 0) {
            this.head = node;
            head.next = null;// check this
            head.back = null;// check this
            length++;
            return;
        } else {
            //System.out.println(item.toString() + " <  " + location.info.toString() + " compare to result "+ item.compareTo(location.info));
            // inserting at the beginning of the list
            if (item.compareTo(head.info) < 0) {
                node.next = head; // make next of new Node as head
                head.back = node; // Move the head to point to new Node
                head = node;
                length++;
                return;
            } else {
                // searching through the list
                while (location != null) {
                    if (location.next == null) {
                        location.next = node;
                        node.back = location;
                        length++;
                        return;
                    }
                    // less than the item next then keep going

                    if (item.compareTo(location.info) < 0) {
                        // debug:System.out.println("break");
                        node.back = prevlocation;
                        location.back = node;
                        break;
                    }
                    // check for duplicate i.e if EQUAL
                    else if (item.compareTo(location.info) == 0) {
                        System.out.println("\nSorry. You cannot insert the duplicate item");
                        return;
                    } // if
                      // shifting
                      // System.out.println("point reached");
                    prevlocation = location;
                    location = location.next;
                } // while

                // adding to the list
                prevlocation.next = node;
                node.next = location;
                length++;
            } // else
        } // else
    }// insertItem

    public void deleteSubsection(T lowerBound, T upperBound) {

        if (head != null) {

            NodeType<T> location = head;
            while (location != null) {
                if (location.info.compareTo(lowerBound) >= 0 && location.info.compareTo(upperBound) <= 0) {
                    deleteItem(location.info);
                } // if

                location = location.next;
            } // while
        } // if
    }

    int getLength() {
        return length;
    }// getLength

    void print() {
        // do a loop over location
        // start location = head then loop until location = null
        NodeType<T> location = head;
        while (location != null) {
            System.out.print(location.info + " ");
            location = location.next;
        } // while

    }// print

    void printReverse() {
        if (this.getLength() == 0) {
            return;
        }

        // searching till the last node of the list
        NodeType<T> lastNode = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        } // while
          // then going from the last node printing backwards
        while (lastNode != head) {
            System.out.print(lastNode.info + " ");
            lastNode = lastNode.back;
        } // while
        if (lastNode == head) {
            System.out.print(lastNode.info + " ");
        }

    }// printReverse

    void reverseList() {
        if (this.getLength() == 0) {
            return;
        }
        NodeType<T> current = head;
        NodeType<T> temp = null;
        while (current != null) {
            temp = current.back; // swapping the back and next nodetype of each node
            current.back = current.next;
            current.next = temp;

            // System.out.print(current.info + " ");
            current = current.back;

            if (temp != null) {
                head = temp.back; // move to the next node of the original list
            }

        } // while

        print();
    }// reverseList

}
