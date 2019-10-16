#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
#include <stack>

using namespace std;

struct Node 
{
	int Value;
	Node* Next;
	Node(int val = 0, Node* next = nullptr) 
	{
		Value = val;
		Next = next;
	}
};

class LinkedList 
{
public:
	void push_back(int val) 
	{
		if (Tail) {
			Tail->Next = new Node(val);
			Tail = Tail->Next;
		}
		else {
			Head = Tail = new Node(val);
		}
		Size++;
	}

	void push_front(int val) 
	{
		Node* oldHead = Head;
		Head = new Node(val, oldHead);
		if (!Tail) 
		{
			Tail = Head;
		}
		Size++;
	}

	void add(int val, int pos) 
	{
		if (pos < 0 || pos > Size) 
		{
			cout << "add_last";
		}

		if (pos == 0) {
			push_front(val);
		}
		else if (pos >= Size || pos < 0) 
		{
			push_back(val);
		}
		else {
			Node* addAfter = Head;
			for (int counter = 1; counter < pos; counter++) 
			{
				addAfter = addAfter->Next;
			}
			addAfter->Next = new Node(val, addAfter->Next);
			Size++;
		}
	}

	void print() 
	{
		Node* i = Head;
		while (i != nullptr) 
		{
			cout << i->Value << '#';
			i = i->Next;
		}
	}

	void pop_front() 
	{
		if (Head) 
		{
			Head = Head->Next;
			if (!Head) 
			{
				Tail = nullptr;
			}
			Size--;
		}
	}
	void pop_back() 
	{
		if (Tail) 
		{
			if (Tail == Head) 
			{
				Tail = Head = nullptr;
			}
			else 
			{
				Node* tmp = Head;
				while (tmp->Next != Tail) 
				{
					tmp = tmp->Next;
				}
				Tail = tmp;
				Tail->Next = nullptr;
			}
			Size--;
		}
	}
	void remove(int pos) 
	{
		if (pos < 0 || pos >= Size) 
		{
			cout << "remove_failed";
			return;
		}
		if (pos == 0) 
		{
			pop_front();
		}
		else if (pos + 1 == Size) 
		{
			pop_back();
		}
		else 
		{
			Node* prev = nullptr;
			Node* i = Head;
			for (int counter = 0; counter < pos; counter++) 
			{
				prev = i;
				i = i->Next;
			}
			prev->Next = i->Next;
			Size--;
		}
	}

	void reverse() 
	{
		Node* i = Head;
		Node* prev = nullptr;
		Node* next = nullptr;
		Head = Tail;
		Tail = i;
		while (i) 
		{
			next = i->Next;
			i->Next = prev;
			prev = i;
			i = next;
		}
	}

	void remove_all(int val) 
	{
		int count = 0;
		Node* i = Head;
		while (i) 
		{
			if (i->Value == val) 
			{
				i = i->Next;
				remove(count);
			}
			else 
			{
				i = i->Next;
				count++;
			}
		}
	}

	void group(int a, int b) 
	{
		if (a < 0 || a >= Size || b < 0 || b >= Size || a > b) 
		{
			cout << "fail_grouping";
			return;
		}
		int sum = 0;
		int count = 0;
		Node* i = Head;
		while (count < a) 
		{
			i = i->Next;
			count++;
		}
		int aPos = count;
		for (; count <= b; count++) 
		{
			sum += i->Value;
			i = i->Next;
		}
		for (count = aPos; count <= b; count++) 
		{
			remove(aPos);
		}
		add(sum, aPos);
	}

	void count(int val) 
	{
		int count = 0;
		Node* i = Head;
		while (i) 
		{
			if (i->Value == val) 
			{
				count++;
			}
			i = i->Next;
		}
		cout << count;
	}

	void is_palindrome() 
	{
		stack<int> stk;
		Node* i = Head;
		while (i) 
		{
			stk.push(i->Value);
			i = i->Next;
		}
		i = Head;
		while (i) 
		{
			if (i->Value != stk.top()) 
			{
				cout << "false";
				return;
			}
			stk.pop();
			i = i->Next;
		}
		cout << "true";
	}

	~LinkedList() 
	{
		Head = nullptr;
		Tail = nullptr;
		Size = 0;
	}

	LinkedList() 
	{
		Head = nullptr;
		Tail = nullptr;
		Size = 0;
	}

private:
	Node* Head;
	Node* Tail;
	int Size;
};

int main() 
{
	int cases;
	std::cin >> cases;
	for (int i = 0; i < cases; i++) 
	{
		LinkedList ll;
		int ops;
		std::string op;
		std::cin >> ops;
		for (int j = 0; j < ops; j++) 
		{
			std::cin >> op;
			if (op == "count") 
			{
				int arg1;
				std::cin >> arg1;
				ll.count(arg1);
			}
			if (op == "add") {
				int arg1, arg2;
				std::cin >> arg1 >> arg2;
				ll.add(arg1, arg2);
			}
			if (op == "print") 
			{
				ll.print();
			}
			if (op == "remove") 
			{
				int arg1;
				std::cin >> arg1;
				ll.remove(arg1);
			}
			if (op == "reverse") 
			{
				ll.reverse();
			}
			if (op == "remove_all") 
			{
				int arg1;
				std::cin >> arg1;
				ll.remove_all(arg1);
			}
			if (op == "group") 
			{
				int arg1, arg2;
				std::cin >> arg1 >> arg2;
				ll.group(arg1, arg2);
			}
			if (op == "is_palindrom") 
			{
				ll.is_palindrome();
			}
		}
		std::cout << std::endl;
	}
	return 0;
}
