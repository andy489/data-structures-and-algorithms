#### FUNCTIONALITY:
- getNode();
- insertAtEnd();
- insertAtBeginning();
- insertAtPosition();
- printLinkedList().
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

void printLinkedList(Node* head)
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

void test()
{
	Node* head = nullptr; /* The identity of the linked list.
							 Not the head, but a pointer to the head.
							 Initialize an empty list. */

	int countNodes, indx, data;
	std::cout << "Enter how many Nodes you would like to insert?\n";
	std::cin >> countNodes;
	for (indx = 0; indx < countNodes; indx++)
	{
		std::cout << "Enter data of Node to insert: ";
		std::cin >> data;
		head = insertAtBeginning(head, data); //head = insertAtEnd(head, data);
		/* insertAtBeginningVoid(&head, data); // second way */
		printLinkedList(head);
	}
	int nodes;
	std::cout << "\nEnter number of Nodes you want to insert with a selectable index:\n";
	std::cin >> nodes;
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~\nInsert " << nodes << " Nodes at position of your choice.\n"
		<< "If position is bigger than the size of the linked list,\n"
		<< "the node will be inserted at the end of the linked list.\n"
		<< "Else if the position is smaller than the first position,\n"
		<< "the node will be inserted at the beginning of the linked list.\n"
		<< "Тhus there are no bad inputs.\n\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	for (int i = 0; i < nodes; i++)
	{
		int pos, data;
		std::cout << "Enter a position to insert Node: ";
		std::cin >> pos;
		std::cout << "Enter data (int) to Node to be inserted: ";
		std::cin >> data;
		head = insertAtPosition(head, data, pos);
		printLinkedList(head);
	}
}

int main()
{
	test();
	return 0;
}
```
