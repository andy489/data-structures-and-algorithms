// https://www.hackerrank.com/contests/practice-7-sda/challenges/autocomplete-19-1/problem

#include <iostream>
#include <unordered_map>

using namespace std;

struct Node {
    int cnt = 0;
    bool end = false;

    unordered_map<char, Node *> children;

    Node() = default;

    explicit Node(bool end) : end(end) {}
};

struct Trie {
    Node *root = new Node();

    void insert(const string &word) const {
        Node *curr = root;
        ++curr->cnt;

        const int LEN = word.length();

        for (int i = 0; i < LEN; ++i) {
            if (!curr->children.count(word[i])) {
                curr->children[word[i]] = new Node(true);
            }

            curr = curr->children[word[i]];
            ++curr->cnt;
        }

        curr->end = true;
    }

    void dfs(Node *curr, string &prefix, int c) {
        if (curr->end) {
            ++c;
        }

        for (pair<char, Node *> kvp : curr->children) {
            prefix.push_back(kvp.first);
            dfs(kvp.second, prefix, c);
            prefix.pop_back();
        }
    }

    size_t cnt_words(string &prefix) const {
        Node *curr = root;
        const int LEN = prefix.length();

        for (int i = 0; i < LEN; ++i) {
            if (!curr->children.count(prefix[i])) {
                return 0;
            }

            curr = curr->children[prefix[i]];
        }

        return curr->cnt;
    }
};

int main() {
    cin.sync_with_stdio(false);
    cin.tie(nullptr);

    Trie auto_complete;

    int n, q;
    cin >> n >> q;

    string word, prefix;
    for (int i = 0; i < n; ++i) {
        cin >> word;
        auto_complete.insert(word);
    }

    while (q--) {
        cin >> prefix;
        cout << auto_complete.cnt_words(prefix) << '\n'; // slower with endl
    }

    return 0;
}