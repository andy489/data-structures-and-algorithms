## Detect loop in a linked list

Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Detect%20Loop%20in%20LL%2001.png)

**Floyd’s Cycle-Finding Algorithm**
Traverse linked list using two pointers. Move one pointer (slow) by one and another pointer (fast) by two. If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Detect%20Loop%20in%20LL%2002.png)

```cpp
#include <iostream>
using namespace std;

struct Node
{
	int data;
	Node* next;
	Node(int data, Node* next = nullptr) :data(data), next(next) {}
};

struct List
{
	Node* head;
	List(Node* head = nullptr) :head(nullptr) {}

	void push(int data)
	{
		Node* newNode = new Node(data);
		newNode->next = head;
		head = newNode;
	}

	bool detectloop()
	{
		Node* slow(head), * fast(head);

		while (slow && fast && fast->next)
		{
			slow = slow->next;
			fast = fast->next->next;
			if (slow == fast)
			{
				return true;
			}
		}
		return false;
	}
};

int main()
{
	List L;
	L.push(20);
	L.push(4);
	L.push(15);
	L.push(10);
	
	L.head->next->next->next->next = L.head;
	L.detectloop()?cout<<"loop found\n":cout<<"no loop\n";

	return 0;
}
```
