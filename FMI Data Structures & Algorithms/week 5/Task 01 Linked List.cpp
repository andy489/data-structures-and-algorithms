#include <iostream>

struct Node
{
	size_t num;
	Node* next;
	Node(size_t num);
};

int main()
{
	size_t N; std::cin >> N;
	Node *head(nullptr), *tail(nullptr);

	for (size_t i = 1; i <= N; i += 2)
	{
		if (tail)
		{
			tail->next = new Node(i);
			tail = tail->next;
		}
		else
		{
			head = tail = new Node(i);
		}
	}

	tail->next = head; // circular linked list

	if (N & 1) // N is even
	{	// because knight at the end will be killed and he is our tail
		head = tail; 
	}
	while (head->next != head /*head->next != tail*/)
	{
		head->next = head->next->next;
		head = head->next;
	}
	std::cout << head->num;
}

Node::Node(size_t num)
{
	this->num = num;
	next = nullptr;
}
