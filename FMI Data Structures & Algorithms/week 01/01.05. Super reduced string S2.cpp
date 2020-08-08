// github.com/andy489

#include <iostream>

using namespace std;

/*
Iterate the string adding every letter to the
answer string and if the latter has two consecutive
letters at any point remove the last two letters and continue.
This problem can also be solved very easily with a stack.
Time complexity - O(n)
Space complexity - O(n), where n is the length of the
string we input
*/

int main() {
    string str, ans;
    cin >> str;

    int ansStrLen = 0, inputStrLen = str.length();
    ans.resize(inputStrLen);

    for (int i = 0; i < inputStrLen; ++i) {
        ans[ansStrLen] = str[i];
        if (ansStrLen != 0) {
            if (ans[ansStrLen - 1] == ans[ansStrLen])
                ansStrLen -= 2;
        }
        ansStrLen++;
    }
    cout << (ansStrLen ? ans.substr(0, ansStrLen) : "Empty String");
}
