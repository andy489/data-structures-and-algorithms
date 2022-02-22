## Task	* Generate Snakes
A **snake** is a sequence of several square blocks, attached one after another. A snake starts with a block at some position and continues with another block to the left, right, up or down, then again with another block to the left, right, up or down, etc. A snake of size **N** consists of a sequence of **N** blocks and is not allowed to cross itself.

You are given a number **N** and you should find all possible snakes of **N** blocks, represented as sequences of moves denoted as: **S** (start), **L** (move left), **R** (move right), **U** (move up) and **D** (move down). Examples (for N = 1, 2, 3, 4, and 5):
 
<p align="center">
  <img src="https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Generate%20Snakes%2001.png" alt="snakes examples"/>
</p>

Note: some figures could look visually the same but represent different snakes, e.g. **SRRDL** and **SRDRU**.

Some snakes (sequences of blocks) are the same and should be printed only once. If after a number of rotations and/or flips two snakes are equal they are considered the same and should be printed only once. For example the snakes **SRRD, SRRU, SLLD, SLLU, SRUU** and **SUUR** are the same:
 
<p align="center">
  <img src="https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Generate%20Snakes%2002.png" alt="same snakes examples"/>
</p>
 
Not all forms consisting of N blocks are snakes of size N. Examples of non-snake forms:
 
<p align="center">
  <img src="https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Generate%20Snakes%2003.png" alt="invalid snakes examples"/>
</p>

**Note: When generating the snakes, there may be different correct answers. When testing your solution, priority should be as follows: R -> D -> L -> U. The visual example above for n = 5 does NOT follow this priority.**

#### Input
-	The input should be read from the console.
-	It will contain an integer number **N** in the range [1...15].
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
10|1047|
15|148752|
16|401629|

#### Solution C++
```cpp
#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

string current_snake;
const int DIR = 4;

unordered_set<string> visited_cells;
unordered_set<string> result;
unordered_set<string> all_possible_snakes;

string rotate(const string &snake);

string reverse(const string &snake);

string flip(const string &snake);

void mark_snake();

void generate_snakes(int index, int row, int col, char direction);

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        current_snake.append("S");
    }

    generate_snakes(0, 0, 0, 'S');

    for (const string &snake : result) {
        cout << snake << '\n';
    }

    cout << "Snakes count = " << result.size();
    return 0;
}

void generate_snakes(int index, int row, int col, char direction) {
    if (index >= current_snake.length()) {
        mark_snake();
    } else {
        string cell = to_string(row) + to_string(col);

        if (!visited_cells.count(cell)) {
            current_snake[index] = direction;

            visited_cells.insert(cell);

            generate_snakes(index + 1, row, col + 1, 'R');
            generate_snakes(index + 1, row + 1, col, 'D');
            generate_snakes(index + 1, row, col - 1, 'L');
            generate_snakes(index + 1, row - 1, col, 'U');

            visited_cells.erase(cell);
        }
    }
}

void mark_snake() {
    string normal_snake(current_snake);

    if (all_possible_snakes.count(normal_snake)) {
        return;
    }

    result.insert(normal_snake);

    string flipped_snake(flip(normal_snake));
    string reversed_snake(reverse(normal_snake));
    string reversed_flipped_snake(flip(reversed_snake));

    for (int i = 0; i < DIR; ++i) {
        all_possible_snakes.insert(normal_snake);
        normal_snake = rotate(normal_snake);

        all_possible_snakes.insert(flipped_snake);
        flipped_snake = rotate(flipped_snake);

        all_possible_snakes.insert(reversed_snake);
        reversed_snake = rotate(reversed_snake);

        all_possible_snakes.insert(reversed_flipped_snake);
        reversed_flipped_snake = rotate(reversed_flipped_snake);
    }
}

string rotate(const string &snake) {
    string new_snake(snake);
    const int LEN = snake.length();

    for (int i = 0; i < LEN; ++i) {
        switch (snake[i]) {
            case 'R':
                new_snake[i] = 'D';
                break;
            case 'D':
                new_snake[i] = 'L';
                break;
            case 'L':
                new_snake[i] = 'U';
                break;
            case 'U':
                new_snake[i] = 'R';
                break;
            default:
                new_snake[i] = snake[i];
                break;
        }
    }
    return new_snake;
}

string reverse(const string &snake) {
    string new_snake(snake);
    new_snake[0] = 'S';

    const int LEN = snake.length();

    for (int i = 1; i < LEN; ++i) {
        new_snake[LEN - i] = snake[i];
    }

    return new_snake;
}

string flip(const string &snake) {
    string new_snake(snake);
    const int LEN = snake.length();

    for (int i = 0; i < LEN; ++i) {
        switch (snake[i]) {
            case 'U':
                new_snake[i] = 'D';
                break;
            case 'D':
                new_snake[i] = 'U';
                break;
            default:
                new_snake[i] = snake[i];
                break;
        }
    }

    return new_snake;
}

```