#include <iostream>
#include <climits>
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

unsigned getMax(Node* head)
{
	unsigned maxData(0);
	while (head != nullptr)
	{
		if (head->data > maxData)
		{
			maxData = head->data;
		}
		head = head->next;
	}
	return maxData;
}

unsigned getSum(Node* head)
{
	unsigned sum(0);
	while (head != nullptr)
	{
		sum += head->data;
		head = head->next;
	}
	return sum;
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

void test()
{
	Node* head = nullptr;
	unsigned data;
	while (std::cin >> data)
	{	//we will use addFront, because time complexity there is constant - O(1)
		head = addFront(head, data); //head = addBack(head, data);
	}
	std::cout << "\nmin: ";  (head != nullptr) ? std::cout << getMin(head) : std::cout << "no min element";
	std::cout << "\nmax: ";  (head != nullptr) ? std::cout << getMax(head) : std::cout << "no max element";
	std::cout << "\nsum: " << getSum(head) << "\n\n";
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
//for full implementation see:
//https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Linked%20List/Singly%20Linked%20List.md
