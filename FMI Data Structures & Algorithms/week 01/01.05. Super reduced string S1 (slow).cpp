// github.com/andy489

#include <iostream>
#include <string>

using namespace std;

void reduceWord(string &word) {
    int len(word.size()), i(0);
    for (; i < len - 1; ++i) {
        if (word[i] == word[i + 1]) {
            word.erase(word.begin() + i);
            word.erase(word.begin() + i);
            len -= 2;
            --i;
        }
    }
}

int main() {
    string word;
    cin >> word;
    reduceWord(word);
    return cout << (word.size() ? word : "Empty String"), 0;
}
