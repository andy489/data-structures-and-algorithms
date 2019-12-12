#include <bits/stdc++.h>
using namespace std;

static const int MAX_SIZE = 100001;

int lsp[MAX_SIZE];

void find_lsp(string word) {
    int i = 1;
    int j = 0;
    lsp[0] = 0;

    while (i < word.size()) {
        if (word[i] == word[j]) {
            lsp[i] = j + 1;
            i++;
            j++;
        } else {
            if (j == 0) {
                lsp[j] = 0;
                i++;
            } else {
                j = lsp[j - 1];
            }
        }
    }
}

int kmp(string text, string word) {
    find_lsp(word);

    int i = 0;
    int j = 0;
    int occurances = 0;

    while (i < text.size()) {
        if (text[i] == word[j]) {
            i++; 
            j++;
            occurances += (j == word.size());
        } else {
            if (j == 0) {
                i++;
            } else {
                j = lsp[j - 1];
            }
        }
    }

    return occurances;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string text;
    string word;

    cin >> text;
    cin >> word;

    cout << kmp(text, word) << "\n";

    return 0;
}
