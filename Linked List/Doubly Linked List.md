## My Doubly Linked List
#### FUNCTIONALITY:
- getNode()
- insertAtHead()
- insertAtTail()
- printDLL()
- reversePrintDLL()

#### IMPLEMENTATION (C++):
```cpp
#include <iostream>

struct Node
{
	Node *prev, *next;
	int data;
};

Node* head;// global variable - pointer to head node.

Node* getNewNode(int data)
{	//C++
	Node* newNode = new Node;
	//C: struct Node* temp=(struct Node*)malloc(sizeof(struct Node));
	newNode->data = data;
	newNode->prev = newNode->next = nullptr;
	return newNode;
}

void insertAtHead(int data)
{
	Node* newNode = getNewNode(data);
	if (head == nullptr)
	{
		head = newNode;
		return;
	}
	head->prev = newNode;
	newNode->next = head;
	head = newNode;
}

void insertAtTail(int data)
{
	Node* newNode = getNewNode(data);
	if (head == nullptr)
	{
		head = newNode;
		return;
	}
	Node* temp = head;
	while (temp->next != nullptr)
	{
		temp = temp->next;
	}
	temp->next = newNode;
	newNode->prev = temp;
}

void printDLL()
{
	Node* temp = head;
	if (temp == nullptr)
	{	// empty list, exit
		std::cout << "empty DLL\n";
		return;
	}
	std::cout << "head-> ";
	while (temp != nullptr)
	{
		std::cout << temp->data << ' ';
		temp = temp->next;
	}
	std::cout << "<-tail\n";
}
void reversePrintDLL()
{
	Node* temp = head;
	if (temp == nullptr)
	{	// empty list, exit
		std::cout << "empty DLL\n";
		return;
	}
	// Going to last Node
	while (temp->next != nullptr)
	{
		temp = temp->next;
	}
	// Traversing backward using prev pointer
	std::cout << "Reverse: tail-> ";
	while (temp != nullptr)
	{
		std::cout << temp->data << ' ';
		temp = temp->prev;
	}
	std::cout << " <-head\n";
}

int main()
{
	insertAtHead(2); insertAtHead(4); insertAtHead(6);
	insertAtTail(8); insertAtTail(10); insertAtTail(12);
	
	printDLL();
	reversePrintDLL();
}
```
