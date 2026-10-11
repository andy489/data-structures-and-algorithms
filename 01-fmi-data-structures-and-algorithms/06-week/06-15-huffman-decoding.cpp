// https://www.hackerrank.com/challenges/tree-huffman-decoding/problem

#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;

const int ASCII = 256;

typedef struct node {
    int freq;
    char data;

    node *left;
    node *right;
} node;

struct cmp_dereference : public binary_function<node *, node *, bool> {
    bool operator()(const node *a, const node *b) const {
        return a->freq > b->freq;
    }
};

typedef priority_queue<node *, vector<node *>, cmp_dereference> prior_queue;

node *huffman_hidden(const string& s) {
    prior_queue pq;
    vector<int> cnt(ASCII);

    for (char i : s) {
        ++cnt[i];
    }

    for (int i = 0; i < ASCII; ++i) {
        node *n_node = new node;
        n_node->left = nullptr;
        n_node->right = nullptr;
        n_node->data = (char) i;
        n_node->freq = cnt[i];

        if (cnt[i]) {
            pq.push(n_node);
        }
    }

    while (pq.size() != 1) {
        node *left = pq.top();
        pq.pop();

        node *right = pq.top();
        pq.pop();

        node *comb = new node;

        comb->freq = left->freq + right->freq;
        comb->data = '\0';

        comb->left = left;
        comb->right = right;

        pq.push(comb);
    }

    return pq.top();
}

void print_codes_hidden(node *root, const string& code, map<char, string> &mp) {
    if (root == nullptr) {
        return;
    }

    if (root->data != '\0') {
        mp[root->data] = code;
    }

    print_codes_hidden(root->left, code + '0', mp);
    print_codes_hidden(root->right, code + '1', mp);

}

void decode_huff(node *root, string s) {
    node *traverse = root;

    for (const char &c:s) {
        if (c == '1') {
            traverse = traverse->right;
        } else {
            traverse = traverse->left;
        }

        if (traverse->data != '\0') {
            cout << traverse->data;
            traverse = root;
        }
    }
}

int main() {
    string s;
    cin >> s;

    node *tree = huffman_hidden(s);
    string code;

    map<char, string> mp;
    print_codes_hidden(tree, code, mp);

    string coded;

    for (char & i : s) {
        coded += mp[i];
    }

    decode_huff(tree, coded);

    return 0;
}
