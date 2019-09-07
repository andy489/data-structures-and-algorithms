**Task** *(Moving zeros)* Given a vector containing numbers, move all the zeros in the vector 

**a)** at its end;

**b)** at its beginning;

**c)** at its middle.

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
	std::vector<int> vec = { 1, 0, 4, 5, 3, 0, 7, 8, 0, 10 };
	printVector(vec);
	std::cout << "Moving zeros to the front...\n";
	moveZerosFront(vec);
	printVector(vec);
	return 0;
}
```
**c)** We will use a) and b)ideas to move zero to the middle for only the half vector. After that we will make the necessary swaps.

```cpp
#include <iostream>
#include <vector>
#include <cmath>

int moveZerosFrontMiddle(std::vector<int>& vec)
{
	unsigned countZerosRight(0);
	int size = vec.size() - 1;
	int middle = size / 2 + 1;
	for (int i = size; i >= middle; i--)
	{
		if (vec[i] != 0)
			vec[size--] = vec[i];
		else countZerosRight++;
	}
	while (size >= middle) vec[size--] = 0;
	return countZerosRight;
}
int moveZerosBackMiddle(std::vector<int>& vec)
{
	unsigned countZerosLeft(0);
	unsigned j = 0;
	unsigned size = vec.size();
	unsigned middle = size / 2;
	for (unsigned i = 0; i < middle; ++i)
	{
		if (vec[i] != 0)
			vec[j++] = vec[i];
		else countZerosLeft++;
	}
	while (j < middle) vec[j++] = 0;
	return countZerosLeft;
}

void printVector(const std::vector<int>& vec)
{
	std::cout << "Vector contents: ";
	for (auto x : vec) std::cout << x << ' ';
	std::cout << std::endl;
}

void moveZerosInTheMiddle(std::vector<int>& vec)
{
	int leftZeros = moveZerosBackMiddle(vec);
	int rightZeros = moveZerosFrontMiddle(vec);
	// printVector(vec);

	/*std::cout << "Left zeros: " << leftZeros << std::endl;
	std::cout << "Reft zeros: " << rightZeros << std::endl;*/

	/* we need to do abs(rightZeros-leftZeros) swaps
	 if rightZeros > leftZeros swap to the left else swap to the right */

	int swapsNeeded = abs(rightZeros - leftZeros) / 2;
	int middle = vec.size() / 2;

	int i = 0;

	if (rightZeros > leftZeros)
	{
		while (i < swapsNeeded)
		{
			int leftIndx = middle - 1 - leftZeros - i;
			int currLeft = vec[leftIndx];
			int rightIndx = middle - 1 + rightZeros - i;
			int currRigth = vec[rightIndx];

			std::swap(vec[leftIndx], vec[rightIndx]);
			printVector(vec);
			i++;
		}
	}
	else if (rightZeros < leftZeros)
	{
		while (i < swapsNeeded)
		{
			int leftIndx = middle - leftZeros + i;
			int currLeft = vec[leftIndx];
			int rightIndx = middle + rightZeros + i;
			int currRigth = vec[rightIndx];

			std::swap(vec[leftIndx], vec[rightIndx]);
			i++;
		}
	}
}

int main()
{
	std::vector<int> vec = { 1, 0, 4, 5, 3, 0, 7, 8, 0, 10 };
	printVector(vec);
	std::cout << "Moving zeros to the middle...\n";
	moveZerosInTheMiddle(vec);
	printVector(vec);
	return 0;
}
```

*Remark: the task would be much more difficult if there were no conditions a) and b). They actually emphasize the basic principle of task analysis - the breakdown of smaller tasks.*
