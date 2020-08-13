// github.com/andy489

// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/challenge-1795

#include <iostream>
#include <stack>

using namespace std;

struct Node {
    Node *left = nullptr, *right = nullptr;
    int data;

    Node(int data) : data(data) {}
};

class BSTree {
    Node *root = nullptr;

public:

    void add(int data) {
        Node *traversal = root, *attach = nullptr;
        while (traversal != nullptr) {
            attach = traversal;
            if (data > traversal->data)
                traversal = traversal->right;
            else if (data < traversal->data)
                traversal = traversal->left;
            else
                return;
        }
        if (attach == nullptr)
            root = new Node(data);
        else if (data > attach->data)
            attach->right = new Node(data);
        else if (data < attach->data)
            attach->left = new Node(data);
    }

    void print() {
        if (root == nullptr)
            return;
        stack<Node *> s;
        s.push(root);
        while (!s.empty()) {
            Node *cur = s.top();
            s.pop();
            cout << cur->data << ' ';
            if (cur->right)
                s.push(cur->right);
            if (cur->left)
                s.push(cur->left);
        }
    }
};

int main() {
    BSTree t;
    int q, data;
    cin >> q;
    string cmd;
    while (q--) {
        cin >> cmd;
        if (cmd == "add") {
            cin >> data;
            t.add(data);
        } else if (cmd == "print")
            t.print();
    }
    return 0;
}
