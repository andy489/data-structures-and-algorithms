// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/challenge-1795

#include <iostream>

using namespace std;

struct Node {
    Node *left = nullptr, *right = nullptr;
    int data;

    explicit Node(int data) : data(data) {}
};

Node *root; // global variables are set to their default value (in this case nullptr)

Node *add(Node *root, int data) {
    if (root == nullptr) {
        return new Node(data);
    } else if (data > root->data) {
        root->right = add(root->right, data);
    } else if (data < root->data) {
        root->left = add(root->left, data);
    }

    return root;
}

void print(Node *root) {
    if (root != nullptr) {
        cout << root->data << ' ';
        print(root->left);
        print(root->right);
    }
}

int main() {
    int q;
    cin >> q;

    string cmd;
    int data;
    while (q--) {
        cin >> cmd;

        if (cmd == "add") {
            cin >> data;
            root = add(root, data);
        } else if (cmd == "print") {
            print(root);
        }
    }

    return 0;
}
