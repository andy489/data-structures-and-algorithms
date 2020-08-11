// github.com/andy489

// https://www.hackerrank.com/contests/practice-6-sda/challenges/attacking-vigorously-the-leaderboard/problem

#include <iostream>
#include <string>

using namespace std;

struct Node {
    double value;
    Node *left;
    Node *right;

    Node(double value, Node *left, Node *right) :
            value(value), left(left), right(right) {}
};

class AVLTree {
    Node *root;

    bool containsRecursive(Node *current, double value) const {
        if (!current)
            return false;
        if (current->value == value)
            return true;
        if (value < current->value)
            return containsRecursive(current->left, value);
        return containsRecursive(current->right, value);
    }

    void printRecursive(Node *current) const {
        if (!current) return;
        printRecursive(current->left);
        cout << current->value << " ";
        printRecursive(current->right);
    }

    Node *remove(Node *r, double value, bool &deleted) {
        if (!r) return r;
        if (value == r->value) {
            deleted = true;
            if (!r->right) {
                Node *tmp = r->left;
                r->left = nullptr;
                delete r;
                return tmp;
            }
            Node *tmp = r->right;
            while (tmp->left)
                tmp = tmp->left;
            swap(r->value, tmp->value);
            r->right = remove(r->right, value, deleted);
            return r;
        }
        if (value < r->value) {
            r->left = remove(r->left, value, deleted);
            return r;
        }
        r->right = remove(r->right, value, deleted);
        return r;
    }

    bool insert(Node *r, double value) {
        if (r == nullptr) {
            root = new Node(value, nullptr, nullptr);
            return true;
        }
        if (value == r->value)
            return false;
        if (value < r->value) {
            if (!r->left) {
                r->left = new Node(value, nullptr, nullptr);
                return true;
            }
            return insert(r->left, value);
        }
        if (!r->right) {
            r->right = new Node(value, nullptr, nullptr);
            return true;
        }
        return insert(r->right, value);
    }

public:
    AVLTree() : root() {}

    bool add(double value) {
        return insert(root, value);
    }

    bool remove(double value) {
        bool deleted = false;
        root = remove(root, value, deleted);
        return deleted;
    }

    bool contains(double value) const {
        if (!root) return false;
        return containsRecursive(root, value);
    }

    void print() const {
        if (!root) return;
        printRecursive(root);
        cout << endl;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    AVLTree tree;
    string operation;
    int N, i(0);
    double num;
    cin >> N;
    cout << fixed;
    for (; i < N; ++i) {
        cin >> operation;
        if (operation != "print") {
            cin >> num;
            if (operation == "add" && !tree.add(num))
                cout << num << " already added\n";
            else if (operation == "remove" && !tree.remove(num))
                cout << num << " not found to remove\n";
            else if (operation == "contains")
                cout << (tree.contains(num) ? "yes" : "no") << endl;
        } else
            tree.print();
    }
}
