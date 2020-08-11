// github.com/andy489

// https://www.hackerrank.com/contests/test4-sda-/challenges/challenge-1693/problem

#include <iostream>
#include <vector>

using namespace std;

class Node {
public:
    int data;
    Node *leftNode;
    Node *rightNode;

    Node(int d) {
        data = d;
        leftNode = NULL;
        rightNode = NULL;
    }
};

class Solution {
public:
    Node *insert(Node *root, int data) {
        if (root == NULL)
            return new Node(data);
        else {
            Node *cur;
            if (data <= root->data) {
                cur = insert(root->leftNode, data);
                root->leftNode = cur;
            } else {
                cur = insert(root->rightNode, data);
                root->rightNode = cur;
            }
            return root;
        }
    }

    void dfs(Node *root, vector<int> &mem, int lvl = 0) {
        if (root == nullptr)
            return;
        ++mem[lvl];
        dfs(root->leftNode, mem, lvl + 1);
        dfs(root->rightNode, mem, lvl + 1);
    }

    void count(Node *root) {
        vector<int> mem;
        mem.assign(1000, 0);
        dfs(root, mem);
        int i(0);
        for (; mem[i]; ++i) {
            if (mem[i + 1])
                cout << mem[i] << ';';
            else
                cout << mem[i];
        }
    }

private:
    int c;
}; //End of Solution

int main() {
    Solution myTree;
    Node *root = NULL;

    int t, data;
    cin >> t;

    while (t--) {
        cin >> data;
        root = myTree.insert(root, data);
    }
    return myTree.count(root), 0;
}
