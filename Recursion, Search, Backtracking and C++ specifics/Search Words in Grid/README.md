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

const int R = 8; // rows and
const int C = 9; // columns in given grid

// helpers for searching in all 8 direction
int x[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int y[] = {-1, 0, 1, -1, 1, -1, 0, 1};

// function for searching in all 8-direction from point
// (row, col) in grid[][]
bool search_word_in_grid(const char **grid, int row, int col, string &word, string &direction) {
    // if first character of word doesn't match with given starting point in grid
    if (grid[row][col] != word[0]) {
        return false;
    }

    int len = word.length();

    // search word in all 8 directions starting from (row, col)
    for (int dir = 0; dir < R; ++dir) {
        // initialize starting point for current direction
        int k;
        int rd = row + x[dir];
        int cd = col + y[dir];

        // first character is already checked, match remaining characters
        for (k = 1; k < len; ++k) {
            if (rd >= R || rd < 0 || cd >= C || cd < 0) { // if out of bound break
                break;
            }

            if (grid[rd][cd] != word[k]) { // if not matched, break
                break;
            }

            // moving in particular direction
            rd += x[dir];
            cd += y[dir];
        }
        // if all character matched, then value of must be equal to length of word
        if (k == len) {
            switch (dir) {
                case 0: {
                    direction = "North-West";
                    break;
                }
                case 1: {
                    direction = "North";
                    break;
                }
                case 2: {
                    direction = "North-East";
                    break;
                }
                case 3: {
                    direction = "West";
                    break;
                }
                case 4: {
                    direction = "East";
                    break;
                }
                case 5: {
                    direction = "South-West";
                    break;
                }
                case 6: {
                    direction = "South";
                    break;
                }
                case 7: {
                    direction = "South-East";
                    break;
                }
                default: {
                    cerr << "invalid direction";
                    return false;
                }
            }
            return true;
        }
    }
    return false;
}

// searches given word in a given matrix in all 8 directions
void pattern_search(const char **grid, string &word, string &direction) {
    bool found_word = false;
    // consider every point as starting point and search given word
    for (int row = 0; row < R; ++row) {
        for (int col = 0; col < C; ++col) {
            if (search_word_in_grid(grid, row, col, word, direction)) {
                found_word = true;
                cout << "Pattern found at ("
                     << row + 1
                     << ", "
                     << col + 1
                     << ") at "
                     << direction
                     << " direction"
                     << endl;
            }
        }
    }
    if (!found_word) {
        cout << "No such word found in the given grid.\n";
    }
}

int main() {
    string direction;
    string word = "NAP";


    const char *grid[C] = {
            "DREAMING",
            "KPMQBEDN",
            "POIZFVTE",
            "TMALFCXZ",
            "POCZLVTS",
            "DFAPJOTB",
            "ROAZFOWH",
            "YNAUNAPW"
    };

    pattern_search(grid, word, direction);

    return 0;
}
```
