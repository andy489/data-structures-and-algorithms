// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/penultimate-descendants

#include <iostream>
#include <vector>
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

    void delete_penultimate_and_print() {
        vector<int> arr;

        queue<Node *> q;
        q.push(root);

        while (!q.empty()) {
            Node *a = q.front();
            q.pop();

            if (a->left != nullptr || a->right != nullptr) {
                if (a->left && a->right) {
                    if (a->left->left == nullptr && a->left->right == nullptr && a->right->left == nullptr &&
                        a->right->right == nullptr) {
                        arr.push_back(a->value);
                    }
                } else {
                    if (a->left) {
                        if (a->left->left == nullptr && a->left->right == nullptr) {
                            arr.push_back(a->value);
                        }
                    } else if (a->right->left == nullptr && a->right->right == nullptr) {
                        arr.push_back(a->value);
                    }
                }
            }

            if (a->left) {
                q.push(a->left);
            }

            if (a->right) {
                q.push(a->right);
            }
        }

        const int SIZE = arr.size();
        for (int i = 0; i < SIZE; ++i) {
            remove(root, arr[i]);
        }

        print(root);
    }

private:
    Node *root;

    void print(Node *r) {
        if (r) {
            print(r->left);
            cout << r->value << " ";
            print(r->right);
        }
    }

    Node *remove(Node *r, int v) {
        if (r == nullptr) {
            return nullptr;
        }

        if (v > r->value) {
            r->right = remove(r->right, v);
        } else {
            if (v < r->value) {
                r->left = remove(r->left, v);
            } else {
                if (r->left == nullptr) {
                    Node *temp = r->right;

                    delete r;

                    return temp;
                }

                Node *sw = r->left;

                while (sw->right) {
                    sw = sw->right;
                }

                r->value = sw->value;
                r->left = remove(r->left, r->value);
            }
        }
        return r;
    }

    Node *insert(Node *curr_node, int value) {
        if (curr_node == nullptr) {
            curr_node = new Node(value);
        } else if (curr_node->value < value) {
            curr_node->right = insert(curr_node->right, value);
        } else if (curr_node->value > value) {
            curr_node->left = insert(curr_node->left, value);
        } else {
            // if we already have this value at the tree - do nothing
        }

        return curr_node;
    }
};

int main() {
    int n;
    cin >> n;
    BST tree;

    int value;
    for (int i = 0; i < n; ++i) {
        cin >> value;
        tree.insert(value);
    }

    tree.delete_penultimate_and_print();

    return 0;
}
