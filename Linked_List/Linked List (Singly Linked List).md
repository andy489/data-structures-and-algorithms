## My Singly Linked List
#### FUNCTIONALITY:
- getNode()
- insertAtEnd()
- insertAtBeginning()
- insertAtPosition()
- **reverseLL_iterative()** *- favourite interview question*
- **reverseLL_recursive()** *- favourite interview question*
- bubbleSortLL()
- merge2sortedLL()
- split() *-fast/slow strategy*
- mergeSort()
- printLL()
- printLL_recursive()
- printLL_reversed_recursive()
- deleteAtPosition()
- eraseLL()
#### IMPLEMENTATION (C++):
```cpp
#include <iostream>
#include <windows.h>
#include <assert.h> // used in moveNode function 
#include <time.h>

struct Node
{
	int data;
	Node* next;
};

Node* getNode(int data) // Creating a Node
{
	Node* newNode = new Node(); // Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data; // (*newNode).data = data;
	newNode->next = nullptr;
	return newNode;
}

Node* insertAtEnd(Node* head, int data)
{
	Node* newNode = getNode(data);
	if (head == nullptr) head = newNode; // if empty linked list
	else
	{
		Node* temp = head; // In order NOT to modify the addess of the head Node
		while (temp->next != nullptr)
		{   // logic to reach the end of the list; (traversing through the list)
			temp = temp->next;
		}
		temp->next = newNode;
	}
	return head;
}

Node* insertAtBeginning(Node* head, int data)
{
	Node* newNode = getNode(data);
	/*if (head != nullptr)*/ newNode->next = head;
	head = newNode;
	return head;
}

void insertAtBeginningVoid(Node** ptrToHead, int data) // second approach
{
	Node* newNode = getNode(data);
	newNode->next = *ptrToHead;
	*ptrToHead = newNode;
}

Node* insertAtPosition(Node* head, int data, int pos)
{
	Node* newNode = getNode(data);
	if (pos < 1)
	{
		return insertAtBeginning(head, data);
	}
	else if (pos == 1) // if we want to insert at the head
	{
		/*newNode->next = head;
		head = newNode;
		return head;*/
		return insertAtBeginning(head, data);
	}
	else
	{
		Node* traverseNode = head;
		for (int i = 0; i < pos - 2; i++)
		{
			if (traverseNode == nullptr)
			{
				return insertAtEnd(head, data);
			}
			traverseNode = traverseNode->next;
		}
		newNode->next = traverseNode->next;
		traverseNode->next = newNode;
		return head;
	}
}

Node* reverseLL_iterative(Node* head)
{
	Node* current = head;  // traversal Node
	Node* prev = nullptr;
	while (current != nullptr)
	{
		Node* next = current->next;
		current->next = prev;
		prev = current;
		current = next;
	}
	head = prev;
	return head;
}

Node* reverseLL_recursive(Node* head)
{
	if (head == nullptr || head->next == nullptr) return head;
	Node* rest = reverseLL_recursive(head->next);
	head->next->next = head;
	head->next = nullptr;

	return rest;
}

Node* bubbleSortLL(Node* head)
{
	if (head == nullptr) return head;
	for (Node* i = head; i->next != nullptr; i = i->next)
	{
		for (Node* j = i->next; j != nullptr; j = j->next)
		{
			if (i->data > j->data)
			{
				std::swap(i->data, j->data);
			}
		}
	}
	return head;
}

void moveNode(Node** destRef, Node** srcRef)
{	/* moveNode() is an utility function takes the node from the front
	of the source, and move it to the front of the dest. It is an error
	to call this function with the source list empty.
	Before calling moveNode(): source == {1, 2, 3}; dest == {3, 4, 5}
	Affter calling MoveNode(): source == {2, 3}; dest == {1, 3, 4, 5} */
	Node* newNode = *srcRef; // the front source node 
	assert(newNode != nullptr); // assuming that newNode is not nullptr	
	*srcRef = newNode->next; // Advance the source pointer 	
	newNode->next = *destRef; // Link the old dest off the new node 	
	*destRef = newNode; // Move dest to point to the new node 
}

Node* merge2sortedLL(Node* L1, Node* L2)
{	//merges two sorted LL into one LL sorted (increasing order)
	Node dummy; // dummy node to collect the result
	Node* tail = &dummy; // tail points to the last result node
	dummy.next = nullptr;

	while (true)
	{
		if (L1 == nullptr)
		{
			tail->next = L2;
			break;
		}
		else if (L2 == nullptr)
		{
			tail->next = L1;
			break;
		}
		if (L1->data <= L2->data) moveNode(&(tail->next), &L1);
		else moveNode(&(tail->next), &L2);
		tail = tail->next;
	}
	return dummy.next;
}

void split(Node* source, Node** frontRef, Node** backRef)
{
	/* Split the nodes of the given list into front and back halves,
	and return the two lists using the reference parameters.
	If the length is odd, the extra node should go in the front list.
	Uses the fast/slow pointer strategy. */
	Node* fast,*slow;
	
	slow = source;
	fast = source->next;

	/* Advance "fast" two nodes, and advance "slow" one node */
	while (fast != nullptr) 
	{
		fast = fast->next;
		if (fast != nullptr) 
		{
			slow = slow->next;
			fast = fast->next;
		}
	}

	/* "slow" is before the midpoint in the list, so split it in two
	at that point. */
	*frontRef = source;
	*backRef = slow->next;
	slow->next = nullptr;
}

void mergeSort(Node** headRef)
{
	Node* head = *headRef;
	Node* L1, *L2;
	if ((head == nullptr) || (head->next == nullptr)) return; // Base case - length 0 or 1 
	split(head, &L1, &L2); // Split head into L1 and L2 sublists 
	// Recursively sort the sublists
	mergeSort(&L1);
	mergeSort(&L2);
	// answer = merge the two sorted lists together 
	*headRef = merge2sortedLL(L1, L2);
}

void printLL(Node* head)
{
	if (head == nullptr) std::cout << "empty linked list\n";
	else
	{
		std::cout << "head: ";
		while (head->next != nullptr)
		{
			std::cout << head->data << " -> ";
			head = head->next;
		}
		std::cout << head->data << " -| end of linked list\n";
	}
}

void printLL_recursive(Node* head, int& count)
{
	if (count == 0 && head == nullptr) std::cout << "empty linked list\n";
	else if (head == nullptr) std::cout << "end of linked list\n"; // Exit condition
	else
	{
		count++;
		if (count == 1)	std::cout << "head: ";
		// First print the data in the node
		if (head->next != nullptr) std::cout << head->data << " -> ";
		else std::cout << head->data << " -| ";
		printLL_recursive(head->next, count); // Recursive call
	}
	count = 0;
}

void printLL_reversed_recursive(Node* head, int& count)
{
	if (head == nullptr && count == 0)
	{
		std::cout << "empty linked list\n";
		return;
	}
	if (head == nullptr) return;
	count++;
	if (count == 1) std::cout << "head: ";
	printLL_reversed_recursive(head->next, count);
	count--;
	if (count != 0)	std::cout << head->data << " -> ";
	else std::cout << head->data << " -| end of linked list\n";
}

Node* deleteAtPosition(Node* head, int n)
{
	if (n < 1) return head;
	Node* traverseNode = head;
	if (n == 1)
	{
		if (head == nullptr) return head;
		head = traverseNode->next; // head now points to second node (nullptr)
		delete traverseNode;
		return head; // or else statement
	}
	for (int i = 0; i < n - 2; i++)
	{
		if (traverseNode->next->next == nullptr) return head;
		traverseNode = traverseNode->next;
	} // traverseNode points to (n-1)th Node
	Node* temp = traverseNode->next; // nth Node
	traverseNode->next = temp->next; // (n+1)th Node
	delete temp; // free(temp);
	return head;
}

Node* eraseLL(Node* head)
{
	while (head != nullptr)
	{
		head = deleteAtPosition(head, 1);
	}
	return head;
}

void test()
{
	Node* head = nullptr; /* The identity of the linked list.
							 Not the head, but a pointer to the head.
							 Initialize an empty list. */

	int countNodes, indx, data;
	std::cout << "Enter how many Nodes you would like to insert at the beginning?\n";
	std::cin >> countNodes;
	for (indx = 0; indx < countNodes; indx++)
	{
		std::cout << "Enter data of Node to insert: ";
		std::cin >> data;
		head = insertAtBeginning(head, data); //head = insertAtEnd(head, data);
		/* insertAtBeginningVoid(&head, data); // second way */
		printLL(head);
	}
	int insertNodes;
	std::cout << "\nEnter number of Nodes you want to INSERT with a selectable index:\n";
	std::cin >> insertNodes;
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~\nInsert " << insertNodes << " Nodes at position of your choice.\n"
		<< "If position is bigger than the size of the linked list,\n"
		<< "the node will be inserted at the end of the linked list.\n"
		<< "Else if the position is smaller than the first position,\n"
		<< "the node will be inserted at the beginning of the linked list.\n"
		<< "Thus there are no bad inputs.\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	for (int i = 0; i < insertNodes; i++)
	{
		int pos, data;
		std::cout << "Enter a position to insert a Node: ";
		std::cin >> pos;
		std::cout << "Enter data (int) to Node to be inserted: ";
		std::cin >> data;
		head = insertAtPosition(head, data, pos);
		printLL(head);
	}
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Printing the linked list ITERATIVELY:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	printLL(head);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Printing the linked list RECURSIVELY:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	int count(0);
	printLL_recursive(head, count);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Printing the linked list RECURSIVELY & REVERSED :\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	printLL_reversed_recursive(head, count);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Reversing the linked list (iteratively):\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	head = reverseLL_iterative(head);
	printLL(head);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Reversing the linked list (recursively):\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	head = reverseLL_recursive(head);
	printLL(head);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Sorting the linked list (bubbleSort):\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	head = bubbleSortLL(head);
	printLL(head);
	int deleteNodes;
	std::cout << "\nEnter number of Nodes you want to DELETE with a selectable index:\n";
	std::cin >> deleteNodes;
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~\nDelete " << deleteNodes << " Nodes at position of your choice.\n"
		<< "If position is bigger than the size of the linked list\n"
		<< "or smaller than 1 - no Node will be deleted.\n"
		<< "Thus there are no bad inputs.\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	for (int i = 0; i < deleteNodes; i++)
	{
		int pos;
		std::cout << "Enter a position at which you want to delete a Node: ";
		std::cin >> pos;
		head = deleteAtPosition(head, pos);
		printLL(head);
	}
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Clearing the linked list:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	head = eraseLL(head);
	printLL(head);
}

void testMerge()
{
	Node* head1 = nullptr;
	Node* head2 = nullptr;
	srand((unsigned)time(0));
	unsigned ran1 = 2 + rand() % 8;
	unsigned ran2 = 2 + rand() % 8;

	for (unsigned i = 0; i < ran1; i++) head1 = insertAtEnd(head1, rand() % 100);
	for (unsigned i = 0; i < ran2; i++) head2 = insertAtEnd(head2, rand() % 100);

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Printing two randomly created Linked Lists:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	printLL(head1);
	printLL(head2);

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Sorting the Lists:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	head1 = bubbleSortLL(head1);
	head2 = bubbleSortLL(head2);
	printLL(head1);
	printLL(head2);

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Merging the Lists:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	Node* res = nullptr;
	res = merge2sortedLL(head1, head2);
	printLL(res);
	std::cout << std::endl;
}

void testMergeSort()
{
	Node* head = nullptr;
	srand((unsigned)time(0));
	unsigned ran = 5 + rand() % 20;

	for (unsigned i = 0; i < ran; i++) head = insertAtEnd(head, rand() % 100);
	
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Printing the randomly created Linked List:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	printLL(head);

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "\n~Printing the sorted List (via Merge Sort):\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	mergeSort(&head);
	printLL(head);
}

int main()
{
	test();
	testMerge();
	testMergeSort();
	return 0;
}
```
