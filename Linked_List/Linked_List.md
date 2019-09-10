- getNode();
- insertAtEnd();
- insertAtBeginning();
- printLinkedList()

```cpp
#include <iostream>
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
	if (head == nullptr) head = newNode;
	else
	{
		Node* temp = head;
		head = newNode;
		head->next = temp;
	}
	return head;
}

/* void insertAtBeginning(Node** ptrToHead, int data) // second approach
{
	Node* newNode = getNode(data);
	if (*ptrToHead == nullptr) *ptrToHead = newNode;
	else
	{
		Node* temp = *ptrToHead;
		*ptrToHead = newNode;
		(*ptrToHead)->next = temp;
	}
}*/

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

int main()
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
		/* insertAtBeginning(&head, data); // second way */
		printLinkedList(head);
	}
	return 0;
}
```
