#### FUNCTIONALITY:
- getNode()
- insertAtEnd()
- insertAtBeginning()
- insertAtPosition()
- **reverseLL_iterative()** *- favourite interview question*
- **reverseLL_recursive()** *- favourite interview question*
- bubbleSortLL()
- printLL()
- printLL_recursive()
- printLL_reversed_recursive()
- deleteAtPosition()
- eraseLL()
#### IMPLEMENTATION (C++):
```cpp
#include <iostream>
#include <windows.h>

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
	bool swapped = false;	
	for (Node* i = head; i->next != nullptr; i=i->next)
	{
		for (Node* j =i->next; j!=nullptr; j=j->next)
		{
			if (i->data>j->data)
			{
				std::swap(i->data, j->data);
			}
		}
	}
	return head;
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

int main()
{
	test();
	return 0;
}
```
