Richa Patel
rbp95309@uga.edu


Sarah Orji
sao91172@uga.edu


We both equally contributed to this assignment
We both brainstormed and planned out assignment 2.
We both planned out implementation for all methods.
We both worked very closely to ensure there was equal contribution on assignment 2.


deleteSubsection pseudocode - O(N) Complexity

if(head != null) {
	while(node != LastNode of the list) {
		if(item > lower && item < upper) {
			delete item;
		}
	 	shift to next item
	}
}





reverseList pseudocode - O(N) Complexity 

while(currentPos isn't null) {
	
	temp = current.back;
	current.back = current.next;
	current.next = temp;
}

if(temp is null) {
	traverse back;
	
}



swapAlt pseudocode


to compile:
javac *.java -d bin


to run:
java -cp bin Orji_Patel_assignment2.DoublyLinkedListDriver <input file name>