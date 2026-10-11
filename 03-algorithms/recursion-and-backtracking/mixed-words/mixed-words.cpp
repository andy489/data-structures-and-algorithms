#include <iostream>
#include <unordered_set>

using namespace std;

int cnt = 0;

void swap(string &word, int first, int second) {
    char temp = word[first];
    word[first] = word[second];
    word[second] = temp;
}

void generate_words(int index, string &word, int len) {
    if (index >= len) {
        for (int i = 1; i < len; ++i) {
            if (word[i] == word[i - 1]) {
                return;
            }
        }

        cnt++;
        cout << word << endl;
    } else {
        unordered_set<int> swapped;
        for (int i = index; i < len; ++i) {
            if (!swapped.count(word[i])) {
                swap(word, index, i);
                generate_words(index + 1, word, len);
                swap(word, index, i);
                swapped.insert(word[i]);
            }
        }
    }
}

int main() {
    string word;
    cin >> word;

    const int LEN = word.length();
    generate_words(0, word, LEN);
    cout << cnt << endl;

    return 0;
}