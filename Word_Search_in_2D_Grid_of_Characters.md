**Task**. *(word matrix)* Given a <img src="https://latex.codecogs.com/svg.latex?\Large&space;2D"> board of characters and a list of words from a dictionary. A word is said to be readable with the matrix if we find such word while traversing into the matrix in only 4 allowed directions. The 4 directions are, Horizontally Left and Right, Vertically Up and Down. Find all the possible readable words on board from the list.

*Example:*
```
  words = {"oath", "pea", "eat", "rain"}

  board = {{'o','a','a','n'},
           {'e','t','a','e'},
           {'i','h','k','r'},
           {'i','f','l','v'}}

  Output: {"eat", "oath"}
```
*Solution (Recursive):*

```cpp
#define N 4

#include <iostream>
#include <vector>
#include <string>

bool finrWordDFS(int x, int y, std::string word, char board[][N], int length)
{
	if (word.length() == length)
	{
		return true;
	}
	if (x < 0 || y < 0 || x >= N || y >= N )
	{
		return false;
	}
	if (board[x][y] == word[length])
	{
		char temp = board[x][y];
		board[x][y] = '#';
		bool rest = finrWordDFS(x - 1, y, word, board, length + 1) ||
			finrWordDFS(x, y + 1, word, board, length + 1) ||
			finrWordDFS(x + 1, y, word, board, length + 1) ||
			finrWordDFS(x, y - 1, word, board, length + 1);
		board[x][y] = temp;
		return rest;
	}
	else return false;
}

bool findMatch(std::string word, char board[][N])
{
	if (word.length() > N*N)
	{
		return false;
	}
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (board[i][j] == word[0])
			{
				if (finrWordDFS(i, j, word, board, 0))
				{
					return true;
				}
			}
		}
	}
	return false;
}

void displayAllReadableInBoardWords(char board[][N], std::vector<std::string> words)
{
	for (size_t i = 0; i < words.size(); i++)
	{
		if (findMatch(words[i], board))
		{
			std::cout << words[i] << '\n';
		}
	}
}

int main()
{
	std::vector<std::string> words = { "oath","pea","eat","rain"};
	char board[][N] = { {'o','a','a','n'},
			    {'e','t','a','e'},
			    {'i','h','k','r'},
			    {'i','f','l','v'} };
	displayAllReadableInBoardWords(board, words);
	return 0;
}
```
