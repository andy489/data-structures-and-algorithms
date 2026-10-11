// https://www.hackerrank.com/contests/doyoulikeit/challenges/doyoulikeit

#include <iostream>
#include <cstring>

using namespace std;

/*
PROBLEM STATEMENT
Write a recursive function that checks if a given word is a palindrome.
*/

/*
Solution
The idea of the function is as follows:
If the string has length of one or zero then
it is a palindrome by definition. Otherwise
it the string is a palindrome when and only
when its first and last characters are equal
and the string between them is also a palindrome.
Time complexity - O(n), Space - O(n), where n is
the length of string we input.
*/

const int MAX = 100;

bool is_pal(char *str, int len) {
    if (len <= 1) {
        return true;
    }

    char l = tolower(str[0]);
    char r = tolower(str[len - 1]);

    bool alnum = iswalnum(l) && iswalnum(r);

    if (alnum && l != r) {
        return false;
    } else {
        bool left_right_shift = alnum && l == r;
        bool left_shift = iswalnum(r);

        if (left_right_shift) {
            return is_pal(str + 1, len - 2);
        } else if (left_shift) {
            return is_pal(str + 1, len - 1);
        } else {
            return is_pal(str, len - 1);
        }
    }
}

int main() {
    char str[MAX];
    cin.getline(str, MAX);

    // note that strlen has linear time complexity
    // so it is unwise to call it every time in the function body

    cout << (is_pal(str, strlen(str)) ? "YES" : "NO");
}
