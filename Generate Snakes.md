## Task	* Snakes
A **snake** is a sequence of several square blocks, attached one after another. A snake starts with a block at some position and continues with another block to the left, right, up or down, then again with another block to the left, right, up or down, etc. A snake of size **N** consists of a sequence of **N** blocks and is not allowed to cross itself.

You are given a number **N** and you should find all possible snakes of **N** blocks, represented as sequences of moves denoted as: **S** (start), **L** (move left), **R** (move right), **U** (move up) and **D** (move down). Examples (for N = 1, 2, 3, 4, and 5):
 
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Generate%20Snakes%2001.png)
 
Note: some figures could look visually the same but represent different snakes, e.g. **SRRDL** and **SRDRU**.

Some snakes (sequences of blocks) are the same and should be printed only once. If after a number of rotations and/or flips two snakes are equal they are considered the same and should be printed only once. For example the snakes **SRRD, SRRU, SLLD, SLLU, SRUU** and **SUUR** are the same:
 
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Generate%20Snakes%2002.png)
 
Not all forms consisting of N blocks are snakes of size N. Examples of non-snake forms:
 
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Generate%20Snakes%2003.png)

**Note: When generating the snakes, there may be different correct answers. When testing your solution, priority should be as follows: R -> D -> L -> U. The visual example above for n = 5 does NOT follow this priority.**

#### Input
-	The input should be read from the console.
-	It will contain an integer number **N** in the range [1 ... 15].
-	The input data will always be valid and in the format described. There is no need to check it explicitly.
#### Output
-	The output should be printed on the console. It should consist of a variable number of lines:
-	Each line should hold a snake represented as a sequence of moves.
-	On the last line, print the number of snakes in format: **"Snakes count = {0}"**.
#### Constraints
-	Allowed working time for your program: 10 seconds. Allowed memory: 512 MB.
#### Examples
Input|	Sample Output|	Comments
-|-|-
2|	SR<br>Snakes count = 1|	Note that **SU, SL** and **SD** are also correct outputs. However, SR takes precedence because R has priority over all other directions.
4|	SRRR<br>SRRD<br>SRDR<br>SRDL<br>Snakes count = 4|Note that there are many other correct outputs for N = 4, but this is the expected output according to the priority of directions (right, down, left, up).
5|SRRRR<br>SRRRD<br>SRRDR<br>SRRDD<br>SRRDL<br>SRDRD<br>SRDRU<br>SRDDR<br>SRDDL<br>Snakes count = 9|

#### Solution C++
```cpp
#include <iostream>
#include <string>
#include <unordered_set>

std::string currentSnake;

std::unordered_set<std::string> visitedCells;
std::unordered_set<std::string> result;
std::unordered_set<std::string> allPossibleSnakes;

std::string Rotate(std::string snake);
std::string Reverse(std::string snake);
std::string Flip(std::string snake);
void MarkSnake();
void GenerateSnakes(size_t index, int row, int col, char direction);

int main()
{
	size_t n; std::cin >> n;
	for (size_t i = 0; i < n; i++) currentSnake += 's';
	
	GenerateSnakes(0, 0, 0, 'S');

	for (auto x : result)
	{
		std::cout << x << '\n';
	}
	std::cout << "Snakes count = " << result.size();
	return 0;
}

void GenerateSnakes(size_t index, int row, int col, char direction)
{
	if (index >= currentSnake.length())
	{
		MarkSnake();
	}
	else
	{
		std::string cell = std::to_string(row) + std::to_string(col);

		if (!visitedCells.count(cell))
		{
			currentSnake[index] = direction;

			visitedCells.insert(cell);

			GenerateSnakes(index + 1, row, col + 1, 'R');
			GenerateSnakes(index + 1, row + 1, col, 'D');
			GenerateSnakes(index + 1, row, col - 1, 'L');
			GenerateSnakes(index + 1, row - 1, col, 'U');

			visitedCells.erase(cell);
		}
	}
}

void MarkSnake()
{
	std::string normalSnake(currentSnake);

	if (allPossibleSnakes.count(normalSnake))
	{
		return;
	}
	result.insert(normalSnake);

	std::string flippedSnake (Flip(normalSnake));
	std::string reversedSnake (Reverse(normalSnake));
	std::string reversedFlippedSnake (Flip(reversedSnake));

	for (size_t i = 0; i < 4; i++)
	{
		allPossibleSnakes.insert(normalSnake);
		normalSnake = Rotate(normalSnake);

		allPossibleSnakes.insert(flippedSnake);
		flippedSnake = Rotate(flippedSnake);

		allPossibleSnakes.insert(reversedSnake);
		reversedSnake = Rotate(reversedSnake);

		allPossibleSnakes.insert(reversedFlippedSnake);
		reversedFlippedSnake = Rotate(reversedFlippedSnake);
	}
}

std::string Rotate(std::string snake)
{
	std::string newSnake(snake);
	size_t length = snake.length();
	for (size_t i = 0; i < length; i++)
	{
		switch (snake[i])
		{
		case 'R': newSnake[i] = 'D'; break;
		case 'D': newSnake[i] = 'L'; break;
		case 'L': newSnake[i] = 'U'; break;
		case 'U': newSnake[i] = 'R'; break;
		default: newSnake[i] = snake[i]; break;
		}
	}
	return newSnake;
}

std::string Reverse(std::string snake)
{
	std::string newSnake(snake);
	newSnake[0] = 'S';
	size_t length = snake.length();
	for (size_t i = 1; i < length; i++)
	{
		newSnake[length - i] = snake[i];
	}
	return newSnake;
}

std::string Flip(std::string snake)
{
	std::string newSnake(snake);
	size_t length = snake.length();
	for (size_t i = 0; i < length; i++)
	{
		switch (snake[i])
		{
		case 'U': newSnake[i] = 'D'; break;
		case 'D': newSnake[i] = 'U'; break;
		default: newSnake[i] = snake[i]; break;
		}
	}
	return newSnake;
}
```

#### Solution C#

```cs
using System;
using System.Collections.Generic;

namespace Snakes 
{
    class Program
    {
        private static char[] currentSnake;

        private static HashSet<string> visitedCells = new HashSet<string>();
        private static HashSet<string> result = new HashSet<string>();
        private static HashSet<string> allPossibleSnakes = new HashSet<string>();

        static void GenerateSnakes(int index, int row, int col, char direction)
        {
            if (index >= currentSnake.Length)
            {
                MarkSnake();
            }
            else
            {
                var cell = $"{row} {col}";

                if (!visitedCells.Contains(cell))
                {
                    currentSnake[index] = direction;

                    visitedCells.Add(cell);

                    GenerateSnakes(index + 1, row, col + 1, 'R');
                    GenerateSnakes(index + 1, row + 1, col, 'D');
                    GenerateSnakes(index + 1, row, col - 1, 'L');
                    GenerateSnakes(index + 1, row - 1, col, 'U');

                    visitedCells.Remove(cell);
                }
            }
        }

        static void MarkSnake()
        {
            var normalSnake = new string(currentSnake);

            if (allPossibleSnakes.Contains(normalSnake))
            {
                return;
            }
            result.Add(normalSnake);

            var flippedSnake = Flip(normalSnake);
            var reversedSnake = Reverse(normalSnake);
            var reversedFlippedSnake = Flip(reversedSnake);
                        
            for (int i = 0; i < 4; i++)
            {
                allPossibleSnakes.Add(normalSnake);
                normalSnake = Rotate(normalSnake);

                allPossibleSnakes.Add(flippedSnake);
                flippedSnake = Rotate(flippedSnake);

                allPossibleSnakes.Add(reversedSnake);
                reversedSnake = Rotate(reversedSnake);

                allPossibleSnakes.Add(reversedFlippedSnake);
                reversedFlippedSnake = Rotate(reversedFlippedSnake);
            }
        }

        private static string Rotate(string snake)
        {
            var newSnake = new char[snake.Length];
            for (int i = 0; i < snake.Length; i++)
            {
                switch (snake[i])
                {
                    case 'R': newSnake[i] = 'D'; break;
                    case 'D': newSnake[i] = 'L'; break;
                    case 'L': newSnake[i] = 'U'; break;
                    case 'U': newSnake[i] = 'R'; break;
                    default: newSnake[i] = snake[i]; break;
                }
            }
            return new string(newSnake);
        }

        private static string Reverse(string snake)
        {
            var newSnake = new char[snake.Length];

            newSnake[0] = 'S';
            for (int i = 1; i < snake.Length; i++)
            {
                newSnake[snake.Length - i] = snake[i];
            }
            return new string(newSnake);
        }

        private static string Flip(string snake)
        {
            var newSnake = new char[snake.Length];

            for (int i = 0; i < snake.Length; i++)
            {
                switch (snake[i])
                {
                    case 'U': newSnake[i] = 'D'; break;
                    case 'D': newSnake[i] = 'U'; break;
                    default: newSnake[i] = snake[i]; break;
                }
            }
            return new string(newSnake);
        }

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            currentSnake = new char[n];

            GenerateSnakes(0, 0, 0, 'S');

            foreach (var snake in result)
            {
                Console.WriteLine(new string(snake));
            }
            Console.WriteLine($"Snakes count = {result.Count}");
        }
    }
}

```
