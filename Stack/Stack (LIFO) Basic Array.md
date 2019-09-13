## My Stack (LIFO - Last-In-First-Out collection)
Stack as ADT (abstract data type): A stack is a list or collection with the restriction that insertion and deletion can be performed only from one end, that we call the top ot stack. 

Applications:
- Function Calls / Recursion
- Undo operation in any editor
- Balanced Parentheses [{()}]
#### FUNCTIONALITY:
- push()
- pop()
- top()
- isEmpty()
#### IMPLEMENTATION (C++):
```cpp
#include <iostream>
#define MAX_SIZE 101
int A[MAX_SIZE]; //global array of integers
int top = -1; //another global variable

void Push(int x)
{
	if (top == MAX_SIZE - 1)
	{	//in case of overflow Push will not succeed
		std::cout << "Error: stack overflow\n";
		return;
	}
	A[++top] = x;
}

void Pop()
{
	if (top == -1)
	{	//if stack is empty we cannot Pop
		std::cout << "Error: No element to pop\n";
		return;
	}
	top--;
}

int Top()
{
	return A[top];
}

bool isEmpty()
{
	if (top == -1) return 1;
	return 0;
}

void printStack()//not typical stack operation
{   //implemented only for testing
	int i;
	std::cout << "Stack: ";
	for (i = 0; i <= top; i++)
	{
		std::cout << A[i] << ' ';
	}
	std::cout << std::endl;
}

int main()
{
	Push(2); printStack();
	Push(8); printStack();
	Push(9); printStack();
	Push(14); printStack();
	Pop(); printStack();
	Push(10); printStack();
	return 0;
}
```
