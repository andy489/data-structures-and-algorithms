#include <iostream>
#include <climits>
#include <windows.h>

struct Node
{
	unsigned data;
	Node *next;
};

Node* getNewNode(unsigned data)
{
	Node* newNode = new Node();
	newNode->data = data;
	newNode->next = nullptr;
	return newNode;
}

Node* add(Node* head, unsigned data)
{
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
	{
		head = add(head, data);
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
