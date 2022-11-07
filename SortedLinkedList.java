package Orji_Patel_assignment1;


public class SortedLinkedList {
    private int length;
    private NodeType head = null;
    private NodeType currentPos = null;// just for the getNextItem();

    /**
     * Initialize a sorted linked list object
     */
    public SortedLinkedList() {

    }// SortedLinkedList

    /**
     * Return the length of the linked list
     * 
     * @return
     */
    public int getLength() {
        return length;
    }

    public NodeType getHead() {
        return this.head;
    }

    /**
     * Inserts item into list
     * @param item
     */
    void insertItem(ItemType item) {
       // System.out.println("item debug line 31: " + item.getValue());

        NodeType node = new NodeType();
        node.setNext(null);
        node.setInfo(item);

        NodeType prevlocation = null;
        NodeType location = head;

        // if inserting when the list is empty
        if (head == null) {
            this.head = node; 
            length++;
            //debug:System.out.println("here 44");
            return;
        }
        else {
            // if inserting at the beginning of the list
            if (item.compareTo(head.getInfo()) < 0) { 
                node.setNext(head); // make next of new Node as head
                head = node; // Move the head to point to new Node
                length++;
                return;
            } else {
                // searching through the list
                while (location != null) {
                    //debug:System.out.println("here 2");
                    //debug:System.out.println("Item " + item.getValue());
                    //debug:System.out.println("location " + location.getInfo().getValue());

                    //less than the item next then keep going
                    if(item.compareTo(location.getInfo()) == -1) {
                        //debug:System.out.println("break");
                        break;
                    }
                    // check for duplicate i.e if EQUAL
                    else if (item.compareTo(location.getInfo()) == 0) {
                        System.out.println("\nSorry. You cannot insert the duplicate item");
                        return;
                    } // if
                        //shifting
                        //debug:System.out.println("point reached");
                       prevlocation = location;
                        location = location.getNext();                    
                } // while
                    //adding to the list
                    prevlocation.setNext(node);
                    node.setNext(location);
                length++;

            } // else
        } // else
    }// insertItem

    /**
     * The node in the list that contains an item equal to
     * the item parameter should be removed. 
     * Should handle all cases of deleting an element.
     * @param item
     */
    
    void deleteItem( ItemType item ) {
        NodeType node = new NodeType();
        //node.setNext(null);
        node.setInfo(item);

        NodeType prevlocation = head;
        NodeType location = head.getNext();

        // if deleting when the list is empty
        if (this.head== null) {
            //this.head = node; 
            System.out.println("\nYou cannot delete from an empty list");
            //return;
        }
        else {
            if(location == null) { //if item doesn't exist
                System.out.println("\nThe item is not present in the list");  
            }//if

            //if deleting the only item in list
            if(item.compareTo(head.getInfo()) == 0 && (this.getLength() == 1)) { 
                this.head = null;
                this.currentPos = null;
                length --;
            }//if
            // if deleting at the beginning of the list
            if (item.compareTo(head.getInfo()) == 0) { 
                head = head.getNext();
                length--;
                return;
            } else {

                // searching through the list
                while (location != null && location.getInfo().compareTo(item) != 0) {
                    //debug:System.out.println("here 2");
                    //debug:System.out.println("Item " + item.getValue());
                    //debug:System.out.println("location " + location.getInfo().getValue());
                    if(location != null && location.getInfo().compareTo(item) == 0) {
                        //debug:System.out.println("break");
                        break;
                    }//if
                        
                        //debug:System.out.println("point reached");
                        //shift
                       prevlocation = location;
                        location = location.getNext();                    
                } // while
                if(location == null) {
                    return;
                }
                    //deleting part
                    prevlocation.setNext(location.getNext());
                length--;
            } // else
            
        } // else

        
    }//deleteItem
    

    /**
     * Prints the list out and its contents
     */
    void printList() {
        //do a loop over location 
        //start location = head then loop until location = null
        NodeType tempHead = head;
        while(tempHead != null) {
            System.out.print(tempHead.getInfo().getValue() + " ");
            tempHead = tempHead.getNext();
     }//while
    }//printList

    

    
    /**
     * Search the linked list that contains an item equal to
     * the parameter item and return its index.
     * Print “Item not found” if the item is not present
     * 
     * @return
     */
    int searchItem(ItemType item) {
        if (head == null) {
            System.out.println("The list is empty");
        }
        int count = 1; //starting @ 1 because list begins is @ index 1
        NodeType temp = head;
        while(temp != null) {
            //if temp (the item we're looking for) is found in the list
            if(temp.getInfo().getValue() == item.getValue()) {
                System.out.println("The item is present at index " + count);
                break;
            }
            temp = temp.getNext(); //search through list
            count++; //index
        }//while
        if(temp == null) { //
            System.out.println("Item not found");
            return 0;
        } else {
            return count;
        }//else    
    }//searchItem


     

    /**
     * This function returns the next item in the list pointed by the
     * currentPos.
     * 
     * @return the next item
     */
    ItemType getNextItem() {    

        if (head == null) { //if list empty
            currentPos = head;
            System.out.println("The list is empty");
            //System.out.println("here");
            return head.getInfo();
            
        }else {  
            if(currentPos == null) { 
                currentPos = head;
                System.out.println(currentPos.getInfo().getValue()); //prints head
                return currentPos.getInfo();
            } //if
            
            if(currentPos.getNext() == null) { //if end of list
                System.out.println("End of the list has reached line");
            }//else if
            
            else {//general case
                currentPos = currentPos.getNext();
                //System.out.println(currentPos);
                System.out.println(currentPos.getInfo().getValue());
                return currentPos.getInfo();
            }
        }
        return currentPos.getInfo();
    }//getNextItem

    /**
     * This will initialize the currentPos variable to null.
     */
    void resetList() {
        currentPos = null;
        System.out.println("Iterator is reset");
    } // resetList


    /**
     *  This function should merge two lists and not include any duplicate items in the list. 
     * If there are duplicates in the two lists, 
     * the merge function should keep only one of the duplicate instances in the resulting list.
     * @param list
     * @return
     */
    public SortedLinkedList mergeList(SortedLinkedList list) {
        NodeType node = this.getHead();
        while(node != null) {
            list.insertItem(node.getInfo());
            node = node.getNext();
        }//while
        return list;
    } //mergeList

    /**
     * This function uses another list, finds the common elements between input
     * list and original list, and then prints the result.
     * @param list
     * @return
     */
    public SortedLinkedList intersection(SortedLinkedList list) {
        SortedLinkedList intersection = new SortedLinkedList();
        NodeType node = list.getHead();
        while(node != null) {
            if(searchItem(node.getInfo()) > 0 ){
                intersection.insertItem(node.getInfo());
            }//if
             node = node.getNext();
        }//while
        return intersection;
    } // intersection

    /**
     * Deletes alternate nodes from the list.
     * @return
     */
    public SortedLinkedList deleteAlternateNode() {
        SortedLinkedList dalterNode = new SortedLinkedList();
        NodeType node = head;
        if(this.getLength() == 0) {
            System.out.println("The list is empty");
        }//if
        while(node != null && node.getNext() != null) {
            //if both the current node and the next node are null
            if(node == null || node.getNext() == null) {
                break;
            }
            node.setNext(node.getNext().getNext());
            node = node.getNext();
        }//while
        return dalterNode;
        
    } // deleteAlternateNode                                                                                               

}
