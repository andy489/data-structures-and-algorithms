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
*First Solution (Recursive):*

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
	if (x < 0 || y < 0 || x >= N || y >= N)
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
	std::vector<std::string> result;
	for (size_t i = 0; i < words.size(); i++)
	{
		if (findMatch(words[i], board))
		{
			result.push_back( words[i]);
		}
	}
	for (size_t i = 0; i < result.size(); i++)
	{
		std::cout << result[i] << '\n';
	}
}

int main()
{
	std::vector<std::string> words = { "oath","pea","eat","rain" };
	char board[][N] = { {'o','a','a','n'},
			    {'e','t','a','e'},
			    {'i','h','k','r'},
			    {'i','f','l','v'} };
	displayAllReadableInBoardWords(board, words);
	return 0;
}
```
*First Solution (Building a Trie):*

*Approach:* We can use backtracking (dfs) to traverse from each character on board to all four direction. In order to do a fast searching, we can use a trie from words in dictionary, as soon as we find a word from dictionary in trie, we remove it from trie, so we don't have duplicates. Also, we can use the board to mark '#' (as previous solution) as visited character to achieve backtracking.

```cpp
#include <iostream>
#include <vector>
#include <string>

struct TrieNode
{
	std::string word;
	std::vector<TrieNode*> children;
	TrieNode() : word{ "" }, children{ std::vector<TrieNode*>(26, nullptr) }{}
};

TrieNode* buildTrie(const std::vector<std::string>& dictionary)
{
	TrieNode* root = new TrieNode();
	for (auto word : dictionary)
	{
		TrieNode* curr = root;
		for (auto c : word)
		{
			int index = c - 'a';
			if (curr->children[index] == nullptr)
			{
				curr->children[index] = new TrieNode();
			}
			curr = curr->children[index];
		}
		curr->word = word;
	}
	return root;
}

void backtrack(std::vector<std::vector<char>>& board, TrieNode* root, unsigned i, unsigned j, 
std::vector<std::string>& result)
{
	char c = board[i][j];
	if (c == '#' || root == nullptr)
	{
		return;
	}

	int index = c - 'a';

	TrieNode* curr = root->children[index];
	if (curr == nullptr)
	{
		return;
	}

	if (curr->word != "")
	{
		result.push_back(curr->word);
		// Reset to avoid duplicates.
		curr->word = "";
	}

	board[i][j] = '#';
	if (i > 0)
	{
		backtrack(board, curr, i - 1, j, result);
	}
	if (j > 0)
	{
		backtrack(board, curr, i, j - 1, result);
	}
	if (i < board.size() - 1)
	{
		backtrack(board, curr, i + 1, j, result);
	}
	if (j < board[0].size() - 1)
	{
		backtrack(board, curr, i, j + 1, result);
	}
	board[i][j] = c;
}

std::vector<std::string> findWords(std::vector<std::vector<char>>& board, 
std::vector<std::string>& dictionary)
{
	std::vector<std::string> result;
	for (unsigned i = 0; i < board.size(); i++)
	{
		for (unsigned j = 0; j < board[0].size(); j++)
		{
			TrieNode* root = buildTrie(dictionary);
			backtrack(board, root, i, j, result);
		}
	}
	return result;
}

template <typename T>
void printVector(const std::vector<T>& vec)
{
	std::cout << "{ ";
	for (auto t : vec)
	{
		std::cout << t << ' ';
	}
	std::cout << '}' << std::endl;
}

void printBoard(const std::vector<std::vector<char>>& board)
{
	for (auto v : board)
	{
		printVector(v);
	}
}

int main()
{
	std::vector<std::vector<char>> board =
	{
		{'o','a','a','n'},
		{'e','t','a','e'},
		{'i','h','k','r'},
		{'i','f','l','v'}
	};

	std::vector<std::string> dictionary = { "oath","pea","eat","rain" };
	std::vector<std::string> result = findWords(board, dictionary);

	std::cout << "Board:" << std::endl;
	printBoard(board);
	std::cout << "\nDictionary:" << std::endl;
	printVector(dictionary);
	std::cout << "\nResult:" << std::endl;
	printVector(result);
	return 0;
}
```
