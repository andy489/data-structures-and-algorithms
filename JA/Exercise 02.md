## Exercises on Associative Containers, Classes and Objects

#### Problem 1 – What are the Odds
Write a program that reads a line of words (sequences of lowercase English letters separated by single spaces) and prints two lines – the first containing all words appearing an odd number of times, sorted alphabetically, and the second containing all words appearing an even number of times, sorted alphabetically. 
#### Examples
Input|Output
-|-
java cpp csharp php php java c java cpp|	c csharp java<br>
cpp php

#### Solution

```cpp
#include <iostream>
#include <map>
#include <sstream>
using namespace std;

enum indexes
{
	ODD_ELEMENTS,
	EVEN_ELEMENTS,

	INDEXES_COUNT
};

int main()
{
	string line;
	getline(cin, line);
	istringstream istr(line);

	map <string, int> wordsCounter;

	while (istr >> line)
	{
		wordsCounter[line]++;
	}

	ostringstream elements[INDEXES_COUNT];

	for (const auto& el : wordsCounter)
	{
		elements[el.second & 1] << el.first << ' ';
		//if (el.second & 1) // odd
		//{
		//	elements[ODD_ELEMENTS] << el.first << ' ';
		//}
		//else //if ((el.second & 1) == 0)
		//{
		//	elements[EVEN_ELEMENTS] << el.first << ' ';
		//}
	}
	cout << elements[ODD_ELEMENTS].str() << '\n' << elements[EVEN_ELEMENTS].str() << '\n';
	return 0;
}
```
## Problem 2 – In Range
You are given a line of integer numbers, followed by another line containing exactly two numbers – the start (inclusive) and end (exclusive) of a range (start will always be less than end). Write a program that prints all numbers from the first line that fall into the range [start, end), in increasing order, without duplicates.

Input|Output
-|-
1 42 13 1 13 10 9 7 4 105<br>7 12|7 9 10
1 42 13 1 13 10 9 4 105<br>7 13|9 10
