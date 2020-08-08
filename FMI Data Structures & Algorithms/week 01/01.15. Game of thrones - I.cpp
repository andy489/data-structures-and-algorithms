// github.com/andy489

#include <iostream>

using namespace std;

/*
Problem statement: https://www.hackerrank.com/challenges/game-of-thrones/problem
*/

int letterUsage[26];

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

Luckily the word can contain only lower letter words, so we
can have an array with length 26 that contains the count of
occurrences of every letter in the word where the occurrences of
'a' are at index 0, the occurrences of 'b' are at index 1 and
so on.

Time complexity - O(n)
Space complexity - O(n), where n is the length of the string we
input.
*/

int main() {
    string str;
    cin >> str;
    int i, SIZE = str.length();
    for (; i < SIZE; ++i)
        ++letterUsage[str[i] - 'a'];

    int oddCntLet(0);
    for (i = 0; i < 26; ++i)
        if (letterUsage[i] & 1)
            ++oddCntLet;

    cout << ((oddCntLet <= 1) ? "YES" : "NO");
}
