// github.com/andy489

/*
If (twice the length of the most common string character does not
exceed the length of the entire string + 1 and the string has at least two
different characters) OR (string is only one character) the answer is YES.
In all other cases, the answer is NO.
*/

#include <iostream>
#include <string>

using namespace std;

int main() {
    string word;
    cin >> word;
    int SIZE = word.length();

    int char_histogram[26]{};

    for (int i = 0; i < SIZE; ++i) {
        ++char_histogram[word[i] - 'a'];
    }

    int max_cnt = 0;
    int cnt_diff_char = 0;

    for (int i : char_histogram) {
        if (i > 0) {
            ++cnt_diff_char;
        }
        if (i > max_cnt) {
            max_cnt = i;
        }
    }

    cout << (((2 * max_cnt <= word.size() + 1 && cnt_diff_char > 1) || word.size() == 1) ? "Yes" : "No");

    return 0;
}
