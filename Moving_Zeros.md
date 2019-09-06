**Task** *(Moving zeros)* Given a vector containing numbers, move all the zeros in the vector 

**a)** at its end;

**b)** at its beginning.

*Example:*

vec = {1, 0, 4, 5, 3, 0, 7, 8, 0, 10}

output = {1, 4, 5, 3, 7, 8, 10, 0, 0, 0}

*Solution:*

**а)** The idea is to move non-zero elements sequentially to next available position starting from 0. After all elements in the array are processed, we fill all remaining indexes by 0.

```cpp
#include <iostream>
#include <vector>

void moveZerosBack(std::vector<int>& vec)
{
	unsigned j = 0;
	unsigned size = vec.size();
	for (unsigned i = 0; i < size; ++i)
	{
		if (vec[i] != 0)
			vec[j++] = vec[i];
	}
	while (j < size) vec[j++] = 0;
}

void printVector(const std::vector<int>& vec) 
{
	std::cout << "Vector contents: ";
	for (auto x : vec) std::cout << x << ' ';	
	std::cout << std::endl;
}

int main()
{
	std::vector<int> vec{ 1, 0, 4, 5, 3, 0, 7, 8, 0, 10 };
	printVector(vec);
	std::cout << "Moving zeros to the back...\n";
	moveZerosBack(vec);
	printVector(vec);
	return 0;
}
```

**b)** Same idea as a), but backwards.

```cpp
#include <iostream>
#include <vector>

void moveZerosFront(std::vector<int>& vec)
{
	int size = vec.size() - 1;
	for (int i = size; i >= 0; i--)
	{
		if (vec[i] != 0)
			vec[size--] = vec[i];
	}
	while (size >= 0) vec[size--] = 0;
	
}

void printVector(const std::vector<int>& vec)
{
	std::cout << "Vector contents: ";
	for (auto x : vec) std::cout << x << ' ';
	std::cout << std::endl;
}

int main()
{
	std::vector<int> vec = { 1,0,4,5,3,0,7,8,0,10 };
	printVector(vec);
	moveZerosFront(vec);
	printVector(vec);
	return 0;
}
```
