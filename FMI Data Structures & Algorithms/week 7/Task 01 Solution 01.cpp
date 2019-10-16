#include <iostream>
#include <sstream>
#include <stack>

struct Node
{
	int value;
	Node* next;
	// Constructor with two arguments, one of which is default
	Node(int value, Node* next = nullptr) : value(value), next(next) {};
};

struct SinglyLinkedList
{
	Node* head, * tail;
	size_t size;

	SinglyLinkedList() :head(nullptr), tail(nullptr), size(0) {}; // Default constructor

	void addAtHead(int X); // Utility function for add 
	void addAtTail(int X); // Utility function for add 
	void add(int X, int pos);

	void remove(int pos);

	void reverse(); // Iterative

	Node* reverseRecursiveUtil(Node* head); // Utility function for recursive reverse function
	void reverseRecursive(); // Recursive

	bool isPalindrom();

	size_t count(int X);

	void removeAll(int X);

	void group(int start, int end);

	// Instead of print function
	friend std::ostream& operator<<(std::ostream& os, const SinglyLinkedList& list);
};

int main()
{
	size_t N, Q; std::cin >> N;

	int el(0), pos(0);

	for (size_t i = 0; i < N; i++)
	{
		SinglyLinkedList list;
		std::cin >> Q; std::cin.ignore();
		for (size_t i = 0; i < Q; i++)
		{

			std::string line; getline(std::cin, line);
			std::istringstream istr(line);

			std::string command; istr >> command;

			if (command == "add")
			{
				istr >> el >> pos;
				list.add(el, pos);
			}
			else if (command == "print")
			{
				std::cout << list;
			}
			else if (command == "remove")
			{
				istr >> pos;
				list.remove(pos);
			}
			else if (command == "sz") std::cout << list.size;
			else if (command == "reverse")
			{	// Both functions work
				// list.reverse();
				list.reverseRecursive();
			}
			else if (command == "is_palindrom")
			{
				list.isPalindrom() ? std::cout << "true" : std::cout << "false";
			}
			else if (command == "count")
			{
				istr >> el;
				std::cout << list.count(el);
			}
			else if (command == "group")
			{
				istr >> el >> pos;
				list.group(el, pos);
			}
			else if (command == "remove_all")
			{
				istr >> el;
				list.removeAll(el);
			}
			else
			{
				int count(0);
				while (istr)
				{
					istr >> command;
					count++;
				}
				i += count-1;
			}
		}
		std::cout << '\n';
	}
	return 0;
}

std::ostream& operator<<(std::ostream& os, const SinglyLinkedList& list)
{
	Node* traverse = list.head;
	while (traverse != nullptr)
	{
		os << traverse->value << '#';
		traverse = traverse->next;
	} //os << '\n';
	return os;
}

void SinglyLinkedList::addAtHead(int X)
{
	Node* newNode = new Node(X);
	if (head == nullptr) // tail will then also point to nullptr
	{
		head = tail = newNode;
	}
	else
	{
		Node* temp = head;
		newNode->next = temp;
		head = newNode;
	}
	size++;
}

void SinglyLinkedList::addAtTail(int X)
{
	Node* newNode = new Node(X);
	if (head == nullptr)
	{
		head = tail = newNode;
	}
	else
	{
		tail->next = newNode;
		tail = newNode;
	}
	size++;
}

void SinglyLinkedList::add(int X, int pos)
{
	if (pos < 0)
	{
		addAtTail(X);
		std::cout << "add_last";
	}
	else if (pos == 0) addAtHead(X);
	/*else if (pos == size)                                                                        //////
	{
		addAtTail(X);
	}*/
	else if (pos > (int)size)
	{
		addAtTail(X);
		std::cout << "add_last";
	}
	else
	{
		Node* newNode = new Node(X);
		Node* traverse = head;
		for (int i = 1; i < pos; i++)
		{
			traverse = traverse->next;
		} // traverse points to (pos-1)th Node		
		Node* temp = traverse->next; // pos-th Node  :  traverse - newNode - temp
		traverse->next = newNode;
		newNode->next = temp;
		size++;
	}
}

void SinglyLinkedList::remove(int pos)
{
	if (pos < 0 || pos >= (int)size)
	{
		std::cout << "remove_failed";
	}
	else if (pos == 0)
	{
		Node* temp = head->next;
		delete head;
		head = temp;
		size--;
	}
	else
	{
		Node* traverse = head;
		for (int i = 0; i < pos - 1; i++)
		{
			traverse = traverse->next;
		} // traverseNode points to (pos-1)th Node
		Node* temp = traverse->next; // pos-th Node (node we want to remove)
		traverse->next = temp->next; // (pos+1)th Node
		if (temp->next == nullptr)
		{
			tail = traverse;
		}
		delete temp; // remove temp;
		size--;
	}
}

void SinglyLinkedList::reverse()
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
}

Node* SinglyLinkedList::reverseRecursiveUtil(Node* node)
{
	if (node == nullptr)
	{
		return nullptr;
	}
	if (node->next == nullptr)
	{
		head = node;
		return node;
	}
	Node* node1 = reverseRecursiveUtil(node->next);
	node1->next = node;
	node->next = nullptr;
	return node;
}

void SinglyLinkedList::reverseRecursive()
{
	reverseRecursiveUtil(head);
}

bool SinglyLinkedList::isPalindrom()
{
	if (size <= 1)
	{
		return true;
	}
	else
	{
		std::stack<int> S;
		Node* traverse = head;
		for (size_t i = 0; i < size / 2; i++)
		{
			S.push(traverse->value);
			traverse = traverse->next;
		}
		if (size & 1)
		{	// If there are odd number of nodes we traverse one more time before we start to compare
			traverse = traverse->next;
		}
		while (!S.empty())
		{
			if (traverse->value == S.top())
			{
				traverse = traverse->next;
				S.pop();
			}
			else return false;
		}
	}
	return true;
}

size_t SinglyLinkedList::count(int X)
{
	size_t counter(0);
	Node* traverse = head;
	while (traverse != nullptr)
	{
		if (traverse->value == X)
		{
			counter++;
		}
		traverse = traverse->next;
	}
	return counter;
}

void SinglyLinkedList::removeAll(int X)
{
	Node* traverse = head;
	Node* prev = nullptr;
	while (traverse != nullptr && traverse->value == X)
	{
		head = traverse->next;
		delete traverse;
		size--;
		traverse = head;
	}
	/* if we are here we know that either the list is empty or it doesn't start with X*/
	while (traverse != nullptr)
	{	// looks like O(n*n) but it's only O(n)	
		while (traverse != nullptr && traverse->value != X)
		{
			prev = traverse;
			traverse = traverse->next;
		}

		if (traverse == nullptr) return;
		prev->next = traverse->next;

		delete traverse;
		traverse = prev->next;
	}
}

void SinglyLinkedList::group(int start, int end)
{
	if (start < 0 || end<0 || start >= (int)size || end >= (int)size || start>end)
	{
		std::cout << "fail_grouping";
		return;
	}
	if (start == end)
	{
		return;
	}
	Node* traverse = head;
	for (int i = 0; i < start - 1; i++)
	{
		traverse = traverse->next;
	} // traverse now points to the element before begin of grouping
	Node* begin = traverse; // we memorize from where we start to group 
	// we will need that information to connect the linked list after the removals
	if (start != 0)
	{	// but if there is no element before begin (i.e. we start from 0)
		traverse = traverse->next; // then don't do this step
	}
	int sum(0);
	for (int i = 0; i < end - start + 1; i++)
	{
		Node* temp = traverse;
		sum += traverse->value;
		traverse = traverse->next;
		delete temp;
	}
	Node* newGroupedNode = new Node(sum);
	if (traverse == nullptr)
	{
		tail = traverse;
	}
	if (start == 0)
	{
		head = newGroupedNode;
	}
	newGroupedNode->next = traverse;
	begin->next = newGroupedNode;
	size -= end - start;
}


