**Task.** Given a 2D grid of characters and a word, find all occurrences of the given word in the grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The 8 directions areleft right up, down and 4 diagonal directions.

*Example:*

D|R|E|A|M|I|N|G
---|---|---|---|---|---|---|---
K|**P**|M|Q|**B**|**E**|**D**|N
P|O|**I**|Z|F|V|T|E
T|M|A|**L**|F|C|X|Z
P|O|C|Z|**L**|V|T|S
D|F|A|**P**|J|**O**|T|B
R|O|**A**|Z|F|O|**W**|H
Y|**N**|A|U|**N**|**A**|**P**|W

In the grid with bold font we can find the words: {DREAMING, PILLOW, BED, NAP}

Input|Output
---|---
NAP| Pattern found at (7,1) at North-East direction.<br>pattern found at (7,4) at East direction.
PILLOW | Pattern found at (1,1) at South-East direction.
BED |Pattern found at (1, 4) at East direction.
REST| No such word found in the given grid.

*Solution:*

```cpp
#include <iostream>
#include <string>
using namespace std;
#define R 8 // Rows and columns in given grid 
#define C 9 

// For searching in all 8 direction 
int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

// Function foe searching in all 8-direction from point 
// (row, col) in grid[][] 
bool search2D(const char grid[R][C], int row, int col, string word, string& direction)
{
	// If first character of word doesn't match with 
	// given starting point in grid. 
	if (grid[row][col] != word[0]) return false;

	int len = word.length();

	// Search word in all 8 directions starting from (row,col) 
	for (int dir = 0; dir < 8; dir++)
	{
		// Initialize starting point for current direction 
		int k, rd = row + x[dir], cd = col + y[dir];

		// First character is already checked, match remaining 
		// characters 
		for (k = 1; k < len; k++)
		{
			// If out of bound break 
			if (rd >= R || rd < 0 || cd >= C || cd < 0)	break;

			// If not matched, break 
			if (grid[rd][cd] != word[k]) break;

			// Moving in particular direction 
			rd += x[dir], cd += y[dir];
		}
		// If all character matched, then value of must 
		// be equal to length of word 
		if (k == len)
		{
			switch (dir)
			{
			case 0:
			{
				direction = "North-West";
				break;
			}
			case 1:
			{
				direction = "North";
				break;
			}
			case 2:
			{
				direction = "North-East";
				break;
			}
			case 3:
			{
				direction = "West";
				break;
			}
			case 4:
			{
				direction = "East";
				break;
			}
			case 5:
			{
				direction = "South-West";
				break;
			}
			case 6:
			{
				direction = "South";
				break;
			}
			case 7:
			{
				direction = "South-East";
				break;
			}
			}
			return true;
		}
	}
	return false;
}

// Searches given word in a given matrix in all 8 directions 
void patternSearch(const char grid[R][C], string word, string& direction)
{
	bool foundWord = false;
	// Consider every point as starting point and search given word 
	for (int row = 0; row < R; row++)
	{
		for (int col = 0; col < C; col++)
		{
			if (search2D(grid, row, col, word, direction))
			{
				foundWord = true;
				cout << "Pattern found at (" << row << ", "
					<< col << ") at " << direction << " direction.\n";
			}
		}
	}
	if (!foundWord)
	{
		cout << "No such word found in the given grid.\n";
	}
}

int main()
{
	string direction;
	const char grid[R][C] = {
		"DREAMING",
		"KPMQBEDN",
		"POIZFVTE",
		"TMALFCXZ",
		"POCZLVTS",
		"DFAPJOTB",
		"ROAZFOWH",
		"YNAUNAPW"
	};

	patternSearch(grid, "NAP", direction);

	return 0;
}
```
