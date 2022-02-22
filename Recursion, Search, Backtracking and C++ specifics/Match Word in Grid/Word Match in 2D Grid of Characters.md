**Task**. *(word matrix)* Given a 2D board of characters and a list of words from a dictionary. A word is said to be readable with the matrix if we find such word while traversing into the matrix in only 4 allowed directions. The 4 directions are, horizontally LEFT and RIGHT, vertically UP and DOWN. Find all the possible readable words on board from the list.

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
#include <iostream>
#include <vector>
#include <string>

using namespace std;

const int N = 4;

bool find_word_dfs(vector<vector<char>> &board, int x, int y, string &word, int length) {
    if (word.length() == length) {
        return true;
    }

    if (x < 0 || y < 0 || x >= N || y >= N) {
        return false;
    }

    if (board[x][y] == word[length]) {
        char temp = board[x][y];
        board[x][y] = '#';
        bool rest = find_word_dfs(board, x - 1, y, word, length + 1) ||
                    find_word_dfs(board, x, y + 1, word, length + 1) ||
                    find_word_dfs(board, x + 1, y, word, length + 1) ||
                    find_word_dfs(board, x, y - 1, word, length + 1);
        board[x][y] = temp;
        return rest;
    } else {
        return false;
    }
}

bool find_match(vector<vector<char>> &board, string &word) {
    if (word.length() > N * N) {
        return false;
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (board[i][j] == word[0]) {
                if (find_word_dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
    }

    return false;
}

void display_all_readable_words(vector<vector<char>> &board, vector<string> &words) {
    vector<string> result;
    for (auto &word : words) {
        if (find_match(board, word)) {
            result.push_back(word);
        }
    }

    for (auto &i : result) {
        cout << i << endl;
    }
}

int main() {
    vector<string> words = {"oath", "pea", "eat", "rain"};
    vector<vector<char>> board = {{'o', 'a', 'a', 'n'},
                                  {'e', 't', 'a', 'e'},
                                  {'i', 'h', 'k', 'r'},
                                  {'i', 'f', 'l', 'v'}};
    display_all_readable_words(board, words);
    return 0;
}
```
*Second Solution (Building a Trie):*

*Approach:* We can use backtracking (dfs) to traverse from each character on board to all four direction. In order to do a fast searching, we can use a trie from words in dictionary, as soon as we find a word from dictionary in trie, we remove it from trie, so we don't have duplicates. Also, we can use the board to mark '#' (as previous solution) as visited character to achieve backtracking.

```cpp
#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Trie_node {
    string word;
    vector<Trie_node *> children;

    Trie_node() : children{vector<Trie_node *>(26, nullptr)} {}
};

Trie_node *build_trie(const vector<string> &dictionary) {
    auto *root = new Trie_node();

    for (const auto &word : dictionary) {
        Trie_node *curr = root;

        for (auto c : word) {
            int index = c - 'a';

            if (curr->children[index] == nullptr) {
                curr->children[index] = new Trie_node();
            }

            curr = curr->children[index];
        }
        curr->word = word;
    }

    return root;
}

void backtrack(vector<vector<char>> &board, Trie_node *root, int i, int j, vector<string> &result) {
    char c = board[i][j];

    if (c == '#' || root == nullptr) {
        return;
    }

    int index = c - 'a';

    Trie_node *curr = root->children[index];

    if (curr == nullptr) {
        return;
    }

    if (!curr->word.empty()) {
        result.push_back(curr->word);
        // reset to avoid duplicates
        curr->word = "";
    }

    board[i][j] = '#';

    if (i > 0) {
        backtrack(board, curr, i - 1, j, result);
    }
    if (j > 0) {
        backtrack(board, curr, i, j - 1, result);
    }
    if (i < board.size() - 1) {
        backtrack(board, curr, i + 1, j, result);
    }
    if (j < board[0].size() - 1) {
        backtrack(board, curr, i, j + 1, result);
    }

    board[i][j] = c;
}

vector<string> find_words(vector<vector<char>> &board, vector<string> &dictionary) {
    vector<string> result;

    for (int i = 0; i < board.size(); ++i) {
        for (int j = 0; j < board[0].size(); ++j) {
            Trie_node *root = build_trie(dictionary);

            backtrack(board, root, i, j, result);
        }
    }

    return result;
}

template<typename T>
void print_vector(const vector<T> &vec) {
    cout << "{ ";

    for (const auto &t : vec) {
        cout << t << ' ';
    }

    cout << '}' << endl;
}

void print_board(const vector<vector<char>> &board) {
    for (const auto &v : board) {
        print_vector(v);
    }
}

int main() {
    vector<vector<char> > board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
    };

    vector<string> dictionary = {"oath", "pea", "eat", "rain"};
    vector<string> result = find_words(board, dictionary);

    cout << "Board:" << endl;
    print_board(board);

    cout << endl << "Dictionary:" << endl;
    print_vector(dictionary);

    cout << endl << "Result:" << endl;
    print_vector(result);

    return 0;
}

```
