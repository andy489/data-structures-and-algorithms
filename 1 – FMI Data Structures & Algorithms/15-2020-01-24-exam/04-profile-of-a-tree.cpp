// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2352

#include <iostream>
#include <map>
#include <queue>

using namespace std;

struct Node {
    Node *left;
    Node *right;
    int value;

    explicit Node(int value) {
        this->value = value;
        this->left = nullptr;
        this->right = nullptr;
    }
};

class BST {

public:
    BST() {
        root = nullptr;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    void print_left_profile() {
        queue<Node *> q;
        q.push(root);

        int row = 0;

        while (!q.empty()) {
            int s = q.size();

            while (s--) {
                Node *cur = q.front();
                q.pop();

                if (cur->left) {
                    q.push(cur->left);
                }

                if (cur->right) {
                    q.push(cur->right);
                }

                if (!m.count(row)) { // map first in row
                    m[row] = cur->value;
                }
            }

            ++row;
        }
        for (const auto &kvp:m) {
            cout << kvp.second << ' ';
        }
    }

private:
    map<int, int> m;
    Node *root;

    Node *insert(Node *curNode, int value) {
        if (curNode == nullptr) {
            curNode = new Node(value);
        } else if (curNode->value < value) {
            curNode->right = insert(curNode->right, value);
        } else if (curNode->value > value) {
            curNode->left = insert(curNode->left, value);
        } else {
            //if we already have this value at the tree - do nothing
        }

        return curNode;
    }
};

int main() {
    int n;
    cin >> n;

    int value;
    BST tree;

    for (int i = 0; i < n; ++i) {
        cin >> value;
        tree.insert(value);
    }

    tree.print_left_profile();

    return 0;
}
