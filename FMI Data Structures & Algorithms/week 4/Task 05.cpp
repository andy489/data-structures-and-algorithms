#include <iostream>
#include <string>

struct Node
{
	Node *next;
	std::string text;

	Node(Node* next = nullptr); //constructor with one default parameter
};

struct List
{
	Node *head, *cursor, *tail;

	List();
	void addFront();

	void goToHead();
	void goToTail();
	void write(char c);
	void parse(char c);

	friend std::ostream& operator<<(std::ostream& os, const List& list);
};

int main()
{
	size_t Q; std::cin >> Q;
	List* lists = new List[Q];

	char input;	std::cin >> input;
	if (Q > 0)
	{
		lists[0].parse(input);
	}
	for (size_t i = 0; i < Q; i++)
	{
		while (std::cin.get(input) && input != '\n')
		{
			lists[i].parse(input);
		}
	}
	for (size_t i = 0; i < Q; i++) std::cout << lists[i];
	return 0;
}

Node::Node(Node* next) : next(next) {}

List::List() //default constructor
{
	head = new Node();
	cursor = head;
	tail = head;
}

void List::addFront()
{
	if (head && head->text.length() != 0)
	{
		Node* newNode = new Node(head);
		head = newNode;
	}
}

void List::goToHead()
{
	cursor = head;
}

void List::goToTail()
{
	cursor = tail;
}

void List::write(char c)
{
	cursor->text += c;
}

void List::parse(char c)
{
	if (c == ']')
	{
		goToTail();
	}
	else if (c == '[')
	{
		addFront();
		goToHead();
	}
	else
	{
		write(c);
	}
}

std::ostream & operator<<(std::ostream & os, const List & list)
{
	Node* traversal = list.head;
	while (traversal)
	{
		os << traversal->text;
		traversal = traversal->next;
	}
	os << '\n'; return os;
}
