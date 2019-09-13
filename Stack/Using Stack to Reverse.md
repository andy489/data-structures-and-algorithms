### Using Stack to reverse
- Reverse a string
- Reverse a linked list

H|E|L|L|O|\0|⇨|O|L|L|E|H|\0
-|-|-|-|-|-|-|-|-|-|-|-|-
0|1|2|3|4|5|reverse |0|1|2|3|4|5

```cpp
#include <iostream>
#include <stack> // stack from standard template library (STL)
#define MAX 128
int myStrlen(char *C)
{
	int len(0);
	for (len; C[len] != '\n' && C[len] != '\0'; len++);
	return len;
}

void reverse(char *C, int n)
{
	std::stack<char> S;
	for (int i = 0; i < n; i++)
	{
		S.push(C[i]);
	}
	for (int i = 0; i < n; i++)
	{
		C[i] = S.top(); // overwrite the character at index i.
		S.pop(); // perform pop.
	}
}

int main()
{
	char C[MAX];
	std::cout << "Enter a string: ";
	fgets(C, MAX, stdin);
	int len = myStrlen(C);
	reverse(C, len);

	std::cout << "Reversed string: ";
	for (unsigned i = 0; C[i] != '\n' && C[i] != '\0'; i++)
	{
		std::cout << C[i];
	}

	return 0;
}
```

Problem: Reverse a Linked List using Stack 
```cpp
#include <iostream>
#include <stack> // stack from standard template library (STL)
struct Node
{
	Node* next;
	int data;
};

Node* getNode(int data) // Creating a Node
{
	Node* newNode = new Node(); // Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data; // (*newNode).data = data;
	newNode->next = nullptr;
	return newNode;
}

Node* insertAtBeginning(Node* head, int data)
{
	Node* newNode = getNode(data);
	/*if (head != nullptr)*/ newNode->next = head;
	head = newNode;
	return head;
}

void printLL(Node* head)
{
	if (head == nullptr) std::cout << "empty linked list\n";
	else
	{
		std::cout << "head: ";
		while (head->next != nullptr)
		{
			std::cout << head->data << " -> ";
			head = head->next;
		}
		std::cout << head->data << " -| end of linked list\n";
	}
}

Node* head = nullptr;

void reverse()
{
	if (head == nullptr) return;
	std::stack<Node*> S;
	Node* temp = head;
	while (temp != nullptr)
	{
		S.push(temp);
		temp = temp->next;
	}
	temp = S.top();	head = temp;
	S.pop();
	while (!S.empty())
	{
		temp->next = S.top();
		S.pop();
		temp = temp->next;
	}
	temp->next = nullptr;
}

int main()
{
	head = insertAtBeginning(head, 5);	head = insertAtBeginning(head, 10);
	head = insertAtBeginning(head, 15);	head = insertAtBeginning(head, 20);

	printLL(head);
	reverse();
	printLL(head);

	return 0;
}
```
