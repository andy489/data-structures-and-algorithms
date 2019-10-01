## My Doubly Linked List (OOP)
#### FUNCTIONALITY:
- getNewNode<br><br>
- addAtHead
- addAtTail
- addAtPosition - *no bad entries*<br><br>
- eraseAtHead
- eraseAtTail
- eraseAtPosition - *no bad entries*<br><br>
- displayDLL
- operator >> - *instead of print/display function*

#### IMPLEMENTATION (C++):
```cpp
#include <iostream>
#include <string>
#include <windows.h>
#include <climits>

struct Node
{
	Node *prev, *next;
	std::string color;
	int number;

	Node(std::string color, int number, Node *prev = nullptr, Node *next = nullptr); //constructor with two default arguments
};

struct DoublyLinkedList
{
	Node *head;
	Node *tail;
	int size = 0;

	DoublyLinkedList();
	// utility function for creating a new Node with two default arguments
	Node* getNewNode(std::string color, int number, Node* prev = nullptr, Node* next = nullptr);

	void addAtHead(std::string color, int number);
	void addAtTail(std::string color, int number);
	void addAtPosition(std::string color, int number, int pos);

	bool eraseAtHead();
	bool eraseAtTail();
	void eraseAtPosition(int pos); // no bad entries

	void displayDLL() const; // print the List

	friend std::ostream& operator<<(std::ostream& os, const DoublyLinkedList& list); // same as print but with operator << for the List
};

void test()
{
	DoublyLinkedList DLL;
	DLL.addAtTail("white", 3); DLL.addAtTail("blue", 4); DLL.addAtHead("green", 2);
	DLL.addAtHead("white", 1); DLL.addAtTail("blue", 5); DLL.addAtTail("green", 6);
	DLL.addAtTail("white", 7); DLL.addAtTail("white", 8); DLL.addAtTail("blue", 9);

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Displaying Doubly Linked List:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	std::cout << DLL;
	std::cout << "head -> " << DLL.head->color << ' ' << DLL.head->number << '\n'
		<< "tail -> " << DLL.tail->color << ' ' << DLL.tail->number << "\nsize: "
		<< DLL.size << '\n';

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Deleting from head and tail:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	DLL.eraseAtHead();
	DLL.eraseAtTail();
	std::cout << DLL;
	std::cout << "head -> " << DLL.head->color << ' ' << DLL.head->number << '\n'
		<< "tail -> " << DLL.tail->color << ' ' << DLL.tail->number << "\nsize: "
		<< DLL.size << '\n';

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Deleting at position 3:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	DLL.eraseAtPosition(3);
	std::cout << DLL;
	std::cout << "head -> " << DLL.head->color << ' ' << DLL.head->number << '\n'
		<< "tail -> " << DLL.tail->color << ' ' << DLL.tail->number << "\nsize: "
		<< DLL.size << '\n';

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Adding at position 3:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	DLL.addAtPosition("red", 489,4);
	std::cout << DLL;
	std::cout << "head -> " << DLL.head->color << ' ' << DLL.head->number << '\n'
		<< "tail -> " << DLL.tail->color << ' ' << DLL.tail->number << "\nsize: "
		<< DLL.size << '\n';
}

int main()
{
	test();
	return 0;
}

Node::Node(std::string color, int number, Node *prev, Node *next)
{
	this->color = color;
	this->number = number;
	this->prev = prev;
	this->next = next;
}

DoublyLinkedList::DoublyLinkedList()
{
	head = tail = nullptr;
}

Node * DoublyLinkedList::getNewNode(std::string color, int number, Node* prev, Node*next)
{
	Node *newNode = new Node(color, number);
	newNode->prev = prev;
	newNode->next = next;
	return newNode;
}

void DoublyLinkedList::addAtHead(std::string color, int number)
{
	Node *newNode = getNewNode(color, number); size++;
	if (head == nullptr) // tail will then also point to nullptr
	{
		head = tail = newNode;
	}
	else
	{
		Node* temp = head;
		newNode->next = temp;
		head = newNode;
		temp->prev = head;
	}
}

void DoublyLinkedList::addAtTail(std::string color, int number)
{
	Node *newNode = getNewNode(color, number); size++;
	if (head == nullptr)
	{
		head = tail = newNode;
	}
	else
	{
		Node* temp = tail;
		tail = newNode;
		newNode->prev = temp;
		temp->next = tail;
		tail = temp->next;
	}
}

void DoublyLinkedList::addAtPosition(std::string color, int number, int pos)
{
	if (pos <= 1) addAtHead(color, number);
	else if (pos > size) addAtTail(color, number);
	else
	{
		Node* traverse = head;
		for (int i = 1; i < pos-1; i++)
		{
			traverse = traverse->next;
		} // traverse points to (pos-1)th Node		
		Node *temp = traverse->next; // pos-th Node   :   traverse - newNode - temp
		Node *newNode = getNewNode(color, number, traverse, temp);
		traverse->next = newNode;
		temp->prev = newNode;
		size++;
	}
}

bool DoublyLinkedList::eraseAtHead()
{
	if (head == nullptr)
	{
		std::cout << "cannot perform erase - list is empty\n";
		return false;
	}
	else if (head->next == nullptr)
	{
		delete head;
		head = tail = nullptr; size--;
		return true;
	}
	else
	{
		head = head->next;
		delete head->prev;
		head->prev = nullptr; size--;
		return true;
	}
}

bool DoublyLinkedList::eraseAtTail()
{
	if (head == nullptr)
	{
		std::cout << "cannot perform erase - list is empty\n";
		return false;
	}
	else if (head->next == nullptr)
	{
		delete head;
		head = tail = nullptr; size--;
		return true;
	}
	else
	{
		tail = tail->prev;
		delete tail->next;
		tail->next = nullptr; size--;
		return true;
	}
}

void DoublyLinkedList::eraseAtPosition(int pos)
{
	if (pos <= 1) eraseAtHead();
	else if (pos >= size) eraseAtTail();
	else
	{
		Node* traverse = head;
		for (int i = 1; i < pos - 1; i++)
		{
			traverse = traverse->next;
		} // traverse points to (pos-1)th Node
		Node* temp = traverse->next; // pos-th Node
		traverse->next = temp->next; // (pos+1)th Node
		temp->next->prev = traverse->next;
		delete temp; size--;
	}
}

void DoublyLinkedList::displayDLL() const
{
	Node* traversal = head;
	if (traversal == nullptr)
	{
		std::cout << "list is empty\n";
		return;
	}
	while (traversal != nullptr)
	{
		std::cout << traversal->color << ' ' << traversal->number << '\n';
		traversal = traversal->next;
	}
}

std::ostream & operator<<(std::ostream & os, const DoublyLinkedList& path)
{
	Node* traversal = path.head;
	if (traversal == nullptr)
	{
		os << "list is empty\n";
	}
	else
	{
		while (traversal != nullptr)
		{
			os << traversal->color << ' ' << traversal->number << '\n';
			traversal = traversal->next;
		}
	}
	return os;
}

```
