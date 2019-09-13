## My Stack (LIFO - Last-In-First-Out collection using LINKED LIST
We will need to Insert/Delete
- at end of List (tail) 
  - *time complexity <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}">, i.e. not an option (Push will not be at a constant time)*
- at beginning of List (head) 
  - *time complexity <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}">, i.e. not an option (Pop will not be at a constant time)*
  
The cost of insertion at beginning on the other hand is big of 1, i.e. constant time <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(1)}">. Equivallently we have the same cost with deleting a node at beginning.

#### FUNCTIONALITY:
- Push()
- Pop()
- Top()
- isEmpty()
#### IMPLEMENTATION (C++):
```cpp
#include <iostream>

struct Node
{
	int data;
	Node* link;
};

Node* top = nullptr; //head

Node* getNewNode(int x)
{
	Node* newNode = new Node;
	//C: struct Node* newNode=(struct Node*)malloc(sizeof(struct Node*));
	newNode->data = x;
	newNode->link = nullptr;
	return newNode;
}

void Push(int x)
{
	Node* temp = getNewNode(x);
	temp->link = top;
	top = temp;
}

void Pop()
{
	Node* temp;
	if (top == nullptr) return;
	temp = top;
	top = top->link;
	delete temp; //free(temp);
}

bool isEmpty()
{
	return top == nullptr;
}

int Top()
{
	if (!isEmpty()) return top->data;
	std::cout << "Error: Stack is Empty\n";
	return 0;
}

void displayStack()//not typical stack operation
{	//implemented only for testing
	struct Node* temp;
	if (top == nullptr)
	{
		std::cout << "\nError: Stack is empty\n";
		return;
	}
	temp = top;
	while (temp != nullptr)
	{
		std::cout << temp->data << " ";
		temp = temp->link;
	}
	std::cout << std::endl;
}

int main()
{
	Push(12); displayStack();
	Push(33); displayStack();
	Push(4); displayStack();
	Push(14); displayStack();
	Pop(); displayStack();
	Push(8); displayStack();

	return 0;
}
```
