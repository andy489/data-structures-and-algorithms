#include <iostream>
#include <vector>

using namespace std;

class Node {
public:
    int data;
    Node *left_node;
    Node *right_node;

    explicit Node(int d) {
        data = d;
        left_node = nullptr;
        right_node = nullptr;
    }
};

class Solution {
public:
    Node *insert(Node *root, int data) {
        if (root == nullptr)
            return new Node(data);
        else {
            Node *cur;
            if (data <= root->data) {
                cur = insert(root->left_node, data);
                root->left_node = cur;
            } else {
                cur = insert(root->right_node, data);
                root->right_node = cur;
            }
            return root;
        }
    }

    void dfs(Node *root, vector<int> &mem, int lvl = 0) {
        if (root == nullptr) {
            return;
        }

        mem[lvl] += root->data;

        dfs(root->left_node, mem, lvl + 1);
        dfs(root->right_node, mem, lvl + 1);
    }

    void count(Node *root) {
        vector<int> mem;
        mem.assign(1e3, 0);

        dfs(root, mem);

        for (int i = 0; mem[i]; ++i) {
            if (mem[i + 1]) {
                cout << mem[i] << ';';
            } else {
                cout << mem[i];
            }
        }
    }
};

int main() {
    Solution my_tree{};
    Node *root = nullptr;

    int t, data;
    cin >> t;

    while (t--) {
        cin >> data;
        root = my_tree.insert(root, data);
    }

    my_tree.count(root);

    return 0;
}
