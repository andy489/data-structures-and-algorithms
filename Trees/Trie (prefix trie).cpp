#include <bits/stdc++.h>
using namespace std;

static const int BASE = 256;

struct prefix_node {
    bool is_word;
    prefix_node* children[BASE];

    prefix_node() {
        is_word = false;
        for (int i = 0; i < BASE; i++) {
            children[i] = nullptr;
        }
    }
};

prefix_node* root;
prefix_node memory_holder[MAX_SIZE];
int mem_cnt;

void add_word(string word) {
    prefix_node* node = root;
    for (char letter : word) {
        if (node->children[letter] == nullptr) {
            node->children[letter] = &memory_holder[mem_cnt++];
        }
        node = node->children[letter];
    }
    node->is_word = true;
}

bool find_word(string word) {
    prefix_node* node = root;
    for (char letter : word) {
        if (node->children[letter] == nullptr) {
            return false;
        }
        node = node->children[letter];
    }
    return node->is_word;
}

void build() {
    int n;
    cin >> n;

    root = new prefix_node();

    for (int i = 0; i < n; i++) {
        string word;
        cin >> word;
        add_word(word);
    }
}

void solve() {
    int q;
    cin >> q;

    for (int i = 0; i < q; i++) {
        string word;
        cin >> word;
        cout << find_word(word) << endl;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    build();
    solve();

    return 0;
}
