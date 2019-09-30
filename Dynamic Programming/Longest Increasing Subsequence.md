## Longest Increasing Subsequence 
*Finding and Reconstructing LIS*

![](https://i.ibb.co/9sM7FMK/seq.png)

***3-5-7-8-9-11** and **3-5-7-8-9-10** are possible solutions for the above example, because both are increasing and with maximum length*

- Goal: find the *largest subsequence of increasing numbers* within a given sequence
- This subsequence is not necessarily contiguous, or unique
- Example: 
  - {**3, 5**, 8, **6, 7**}->{3, 5, 6, 7}
  
#### Optimal Sub-Structure
- **Break up** the problem into **sub-problems**
- Characterize the structure of an **optimal solution**
- **Compute** the optimal solutions, typically in a bottom-up fashion
- Construct an **optimal solution** from computed information (*Optimal sub-structure*)

#### Memorization
- DP -> sub-problems **overlap**
- In order to **avoid solving** problems **multiple times**, memorize
  - **Memorization** -> **save/cache** sub-problem solutions **for later use**

- Example:
  - **Save** the length of the LIS **starting/ending** with each number
  
  ![](https://i.ibb.co/19yTTW7/seq2.png)

- Iterative approach

![](https://i.ibb.co/PFJsFHq/seq3.png)

For every sub-problem we find the optimal solution and use it to solve the next larger sub-problem problem until we solve the whole problem.

#### Solution C++
```cpp
#include <iostream>
#include <vector>
int numbers[] = { 3,14,5,12,15,7,8,9,11,10,1 }; int n = sizeof(numbers) / sizeof(numbers[0]);
int* solutions = new int[n];
int* prev = new int[n];

int maxSolution(0), maxSolutionIndex(0);

int main()
{
	for (int current = 0; current < n; current++)
	{
		int solution(1), prevIndex(-1);
		int currentNumber = numbers[current];
		for (int solIndex = 0; solIndex < current; solIndex++)
		{
			int prevNumber = numbers[solIndex];
			int prevSolution = solutions[solIndex];

			if (currentNumber > prevNumber && solution <= prevSolution)
			{
				solution = prevSolution + 1;
				prevIndex = solIndex;
			}
		}
		solutions[current] = solution;
		prev[current] = prevIndex;

		if (solution > maxSolution) // >= for last best solution
		{
			maxSolution = solution;
			maxSolutionIndex = current;
		}
	}
	std::cout << maxSolution << '\n';
	int index = maxSolutionIndex;

	std::vector<int> result;
	while (index != -1)
	{
		int currentNumber = numbers[index];
		result.push_back(currentNumber);
		index = prev[index];
	}
	for (int i = (int)result.size() - 1; i >= 0; i--)
	{
		std::cout << result[i] << ' ';
	}std::cout << '\n';
	return 0;
}
```
#### Solution C#

```cs
using System;
using System.Collections.Generic;

namespace LongestIncreasingSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            var numbers = new[] { 3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1 };

            var solutions = new int[numbers.Length];
            var prev = new int[numbers.Length];

            var maxSolution = 0;
            var maxSolutionIndex = 0;

            for (int current = 0; current < numbers.Length; current++)
            {
                var solution = 1;
                var prevIndex = -1;
                var currentNumber = numbers[current];
                for (int solIndex = 0; solIndex < current; solIndex++)
                {
                    var prevNumber = numbers[solIndex];
                    var prevSolution = solutions[solIndex];

                    if (currentNumber > prevNumber && solution <= prevSolution)
                    {
                        solution = prevSolution + 1;
                        prevIndex = solIndex;
                    }
                }
                solutions[current] = solution;
                prev[current] = prevIndex;

                if (solution > maxSolution) // >= for last best solution
                {
                    maxSolution = solution;
                    maxSolutionIndex = current;
                }
            }
            Console.WriteLine(maxSolution);

            var index = maxSolutionIndex;

            var result = new List<int>();

            while (index != -1)
            {
                var currentNumber = numbers[index];
                result.Add(currentNumber);
                index = prev[index];
            }
            result.Reverse();
            Console.WriteLine(string.Join(" ",result));
        }
    }
}
```
