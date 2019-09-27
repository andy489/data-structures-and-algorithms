#include <iostream>
#include <set>
#include <windows.h>

struct Node
{
	unsigned data;
	Node *next;
};

Node* getNewNode(unsigned data)
{	// creates new node
	Node* newNode = new Node();
	newNode->data = data;
	newNode->next = nullptr;
	return newNode;
}

Node* addBack(Node* head, unsigned data)
{	// adds at end of the linked list - time complexity О(n)
	Node* nodeToAdd = getNewNode(data);
	if (head == nullptr)
	{
		head = nodeToAdd;
	}
	else
	{
		Node* traversal = head;
		while (traversal->next != nullptr)
		{
			traversal = traversal->next;
		}
		traversal->next = nodeToAdd;
	}
	return head;
}

Node* addFront(Node* head, unsigned data)
{	// adds at head of the linked list - time complexity O(1)
	Node* nodeToAdd = getNewNode(data);
	if (head == nullptr)
	{
		head = nodeToAdd;
	}
	else
	{
		Node* temp = head;
		head = nodeToAdd;
		nodeToAdd->next = temp;
	}
	return head;
}

unsigned getMin(Node* head)
{
	unsigned minData = UINT_MAX;
	while (head != nullptr)
	{
		if (head->data < minData)
		{
			minData = head->data;
		}
		head = head->next;
	}
	return minData;
}

void printLinkedList(Node* head)
{
	if (head == nullptr)
	{
		std::cout << "list is empty\n";
	}
	else
	{
		std::cout << "head: ";
		while (head != nullptr)
		{
			std::cout << head->data;
			if (head->next != nullptr)	std::cout << " -> ";
			else std::cout << " -||\n";
			head = head->next;
		}
	}
}

unsigned countNeighbouringPairs(Node* head, const std::set<unsigned>& set)
{
	unsigned counter(0);
	while (head->next != nullptr)
	{
		if (set.count(head->data) && set.count(head->next->data))
		{
			std::cout << '(' << head->data << ',' << head->next->data << ")\n";
			counter++;
		}
		head = head->next;
	}
	return counter;
}

void test()
{
	Node* head = nullptr; // Pointer to head

	size_t N, P; std::cin >> N;
	for (size_t i = 0; i < N; i++)
	{
		unsigned data; std::cin >> data;
		head = addBack(head, data);
	}

	std::set<unsigned> set;

	std::cin >> P;
	for (size_t i = 0; i < P; i++)
	{
		unsigned element; std::cin >> element;
		set.insert(element);
	}

	std::cout << "Answer: " << countNeighbouringPairs(head, set) << '\n';

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Displaying Linked List: \n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	printLinkedList(head);
}

int main()
{
	test();
	return 0;
}
