// https://www.hackerrank.com/challenges/game-of-thrones/problem

#include <iostream>

using namespace std;

/*
Solution
For this problem we need to make the observation
that if the count of occurrences for every letter in the
word is an even number the word can obviously be rearranged
so that it is a palindrome with even length. If there is only
one letter with odd count of occurrences in the word it could
also be rearranged so that it is a palindrome with odd length,
but if there are more than one letters with odd count of
occurrences then the string cannot be rearranged to a palindrome.

This observation reduces the problem to the following: find the
number of letters with odd count of occurrences in the word.
Or even more simpler, if more than 1 letter appears odd times
then the answer is NO.

Luckily the word can contain only lower letter words, so we
can have an array with length 26 that contains the count of
occurrences of every letter in the word where the occurrences of
'a' are at index 0, the occurrences of 'b' are at index 1 and
so on.

Time complexity - O(n)
Space complexity - O(n), where n is the length of the string we
input.
*/

const int SIGMA = 26; // alphabet size

int main() {
    string str;
    cin >> str;

    int char_histogram[SIGMA]{};
    const int SIZE = str.length();

    for (int i = 0; i < SIZE; ++i) {
        ++char_histogram[str[i] - 'a'];
    }

    int odd_cnt_char = false;

    for (int occ : char_histogram) {
        if (occ & 1) {
            if (odd_cnt_char) {
                cout << "NO";
                return 0;
            }
            odd_cnt_char = true;
        }
    }

    cout << "YES";

    return 0;
}