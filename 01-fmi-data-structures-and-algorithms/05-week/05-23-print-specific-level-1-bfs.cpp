// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/print-specific-level

#include <iostream>
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

    void BFS(Node *root, int k) {
        if (k == 0) {
            cout << root->value;
            return;
        }

        int level = 1;
        if (root == nullptr) {
            return;
        }

        queue<Node *> q, ans;
        q.push(root);

        while (!q.empty()) {
            int SIZE = q.size();
            Node *temp;

            while (SIZE--) {
                temp = q.front();
                q.pop();

                if (temp->right) {
                    q.push(temp->right);
                }

                if (temp->left) {
                    q.push(temp->left);
                }

                if (k == level) {
                    if (temp->right) {
                        ans.push(temp->right);
                    }

                    if (temp->left) {
                        ans.push(temp->left);
                    }
                }
            }
            level++;
        }
        while (!ans.empty()) {
            cout << ans.front()->value << ' ';
            ans.pop();
        }
    }

    void print_k_distant(int k) {
        BFS(root, k);
    }

private:
    //you can write helper functions if needed
    Node *root;

    Node *insert(Node *curNode, int value) {
        if (curNode == nullptr) {
            curNode = new Node(value);
        } else if (curNode->value < value) {
            curNode->right = insert(curNode->right, value);
        } else if (curNode->value > value) {
            curNode->left = insert(curNode->left, value);
        } else {
            // if we already have this value at the tree - do nothing
        }

        return curNode;
    }
};

int main() {
    int n, value, k;
    cin >> n;
    
    BST tree;

    for (int i = 0; i < n; ++i) {
        cin >> value;
        tree.insert(value);
    }

    cin >> k;

    tree.print_k_distant(k);

    return 0;
}
