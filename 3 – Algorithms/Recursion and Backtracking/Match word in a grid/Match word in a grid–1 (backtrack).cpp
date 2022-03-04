/*
 * Task: Given a 2D board of characters and a list of words from a dictionary. 
 * A word is said to be readable with the matrix if we find such word while 
 * traversing into the matrix in only 4 allowed directions. The 4 directions 
 * are, horizontally LEFT and RIGHT, vertically UP and DOWN. Find all the 
 * possible readable words on board from the list.
 */

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
        char mem = board[x][y];
        board[x][y] = '#';
        bool rest = find_word_dfs(board, x - 1, y, word, length + 1) ||
                    find_word_dfs(board, x, y + 1, word, length + 1) ||
                    find_word_dfs(board, x + 1, y, word, length + 1) ||
                    find_word_dfs(board, x, y - 1, word, length + 1);
        board[x][y] = mem;
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
