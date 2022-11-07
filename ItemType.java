package Orji_Patel_assignment1;

public class ItemType {
private int value;



//default constructor
public ItemType () {
    value = 0;
}


/**
 * Initializes the data member by variable num
 * @param num
 * @return
 */

void initialize(int num) {
    value = num;
}
 
public ItemType(int value) {
    this.value = value;
}


/**
 * Compares the value of item with the current object's value 
 * and return -1 if value of the current object is less than 
 * value in item , 0 if equal and 1 if greater.
 * @param item
 * @return
 */
int compareTo(ItemType item) {
    if (value < item.getValue()) {
        return -1;
    }
    else if (value > item.getValue()) {
        return 1;
    } else {
        return 0;
    }
}//compareTo



/**
 * Returns the value instance variable
 * @return value
 */
int getValue() {
return value;
}//getValue

void print() {
    System.out.print(value);
}




}//ItemType


