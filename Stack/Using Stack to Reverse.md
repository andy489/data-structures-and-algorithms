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
