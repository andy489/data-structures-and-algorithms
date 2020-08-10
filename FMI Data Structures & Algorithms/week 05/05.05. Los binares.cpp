// github.com/andy489

// https://www.hackerrank.com/contests/practice-5-sda/challenges/los-binares

#include <iostream>
#include <vector>

using namespace std;

struct Node {
    Node *left, *right;
    int data, level;

    Node(int data = 0, int level = 0, Node *left = nullptr, Node *right = nullptr) :
            data(data), level(level), left(left), right(right) {};
};

Node *insert(Node *root, int data, int level = 0) {
    if (root == nullptr) 
        root = new Node(data, level);
    else if (data < root->data)
        root->left = insert(root->left, data, level + 1);
    else if (data > root->data)
        root->right = insert(root->right, data, level + 1);
    return root;
}

int search(Node *root, int data) {
    if (root == nullptr) return -1;
    else if (root->data == data) 
        return root->level;
    else if (data < root->data) //search left subtree
        return search(root->left, data); //recursive call
    else if (data > root->data) //search right subtree
        return search(root->right, data);
    return -1;
}

int main() {
    int N, K, data, address, i(0);
    cin >> N >> K;
    Node *root = nullptr;
    for (; i < N; ++i) {
        cin >> data;
        root = insert(root, data);
    }
    vector<int> result;
    result.reserve(K);

    for (i = 0; i < K; ++i) {
        cin >> address;
        int level = search(root, address);
        result.push_back(level);
    }
    for (const auto &d:result)
        cout << d << '\n';
    return 0;
}
