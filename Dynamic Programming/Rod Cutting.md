## Rod Cutting
Find the best way to cut up a rod with a specified length. You are also given to prices of all possible lengths starting from 0.
#### Examples
Input|	Output
-|-
0 1 5 8 9 10 17 17 20 24 30<br>4|	10<br>2 2
0 1 5 8 9 10 17 17 20 24 30<br>8|	22<br>2 6
0 1 5 8 9 10 17 17 20 24 30<br>10|	30<br>10

#### Solution
```cpp
#include <iostream>

int prices[] = { 0,1,5,8,9,10,17,17,20,24,30 };
int n = sizeof(prices) / sizeof(prices[0]);
int *index, *memo;

int getMax(int a, int b)
{
	return a > b ? a : b;
}

int cutRodRecursive(int length)
{
	if (memo[length] != 0) return memo[length];
	if (length == 0) return 0;
	else
	{
		int max = 0;
		int wholePart = length;
		for (int i = 1; i <= length; i++)
		{
			int currentMax = getMax(prices[i], prices[i] + cutRodRecursive(length - i));
			if (currentMax > max)
			{
				wholePart = i;
				max = currentMax;
			}
		}
		index[length] = wholePart;
		memo[length] = max;
		return memo[length];
	}

}

void printSolution(int length)
{
	while (length != 0)
	{
		std::cout << index[length] << ' ';
		length = length - index[length];
	}
}

int main()
{
	int length; std::cin >> length;
	memo = new int[n](); index = new int[n]();
	std::cout << cutRodRecursive(length) << '\n';
	printSolution(length);
	return 0;
}
```
