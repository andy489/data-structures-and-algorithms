// https://www.hackerrank.com/challenges/reduced-string/problem

#include <iostream>

using namespace std;

/*
Iterate the string adding every letter to the
answer string and if the letter has two consecutive
letters at any point remove the last two letters and continue.
This problem can also be solved very easily with a stack.
Time complexity - O(n)
Space - O(n), where n is the length of the string we input
*/

int main() {
    string str, ans;
    cin >> str;

    int ans_str_len = 0;
    int input_str_len = str.length();

    ans.resize(input_str_len);

    for (int i = 0; i < input_str_len; ++i) {
        ans[ans_str_len] = str[i];
        if (ans_str_len != 0) {
            if (ans[ans_str_len - 1] == ans[ans_str_len]) {
                ans_str_len -= 2;
            }
        }
        ans_str_len++;
    }
    cout << (ans_str_len ? ans.substr(0, ans_str_len) : "Empty String");
}
