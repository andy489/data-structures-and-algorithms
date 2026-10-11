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