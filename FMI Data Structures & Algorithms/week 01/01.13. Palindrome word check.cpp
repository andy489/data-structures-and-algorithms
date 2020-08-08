// github.com/andy489 

#include <iostream>

using namespace std;

/*
PROBLEM STATEMENT
Write a recursive function that checks if
a given word is a palindrome.
*/

/*
Solution
The idea of the function is as follows:
If the string has length of one or zero
then it is a palindrome by definition.
Otherwise it the string is a palindrome
when and only when its first and last
characters are equal and the string between
them is also a palindrome.
Time complexity - O(n)
Space complexity - O(n), where n is
the length of string we input
*/

bool isPal(char *str, int len) {
    if (len <= 1)
        return true;
    return (str[0] == str[len - 1]) && isPal(str + 1, len - 2);
}

int main() {
    char str[1000];
    cin >> str;
    ///note that strlen has linear time complexity so it is unwise to call it every time in the function body
    ///that would make the time complexity of the solution quadratic.
    cout<<(isPal(str, strlen(str)) ? "yes" : "no");
}
