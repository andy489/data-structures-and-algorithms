// https://www.hackerrank.com/challenges/swap-nodes-algo/problem

#include <iostream>
#include <vector>
#include <queue>
#include <sstream>

using namespace std;

struct Node {
    Node *left, *right;
    int data;

    explicit Node(int data, Node *left = nullptr, Node *right = nullptr) :
            data(data), left(left), right(right) {}
};

vector<Node *> nodes;
Node *root;
ostringstream os;

void inorder(Node *root) {
    if (root) {
        inorder(root->left);
        os << root->data << ' ';
        inorder(root->right);
    }
}

void bfs(Node *root, int k) {
    queue<Node *> q;
    q.push(root);

    int curr_row = 1;

    while (!q.empty()) {
        int curr_size = q.size();

        while (curr_size--) {
            Node *cur = q.front();
            q.pop();

            if (curr_row % k == 0){
                swap(cur->left, cur->right);
            }

            if (cur->left){
                q.push(cur->left);
            }

            if (cur->right){
                q.push(cur->right);
            }
        }
        ++curr_row;
    }
}

int main() {
    int n;
    cin >> n;

    nodes.resize(n + 1);

    for (int i = 1; i <= n; ++i) {
        nodes[i] = new Node(i);
    }

    int l,r;
    for (int i = 1; i <= n; ++i) {
        cin >> l >> r;

        if (l != -1){
            nodes[i]->left = nodes[l];
        }

        if (r != -1){
            nodes[i]->right = nodes[r];
        }
    }

    root = nodes[1];

    int q;
    cin >> q;

    int k;
    while (q--) {
        cin >> k;
        bfs(root, k);

        inorder(root);

        os << endl;
    }
    cout << os.str();

    return 0;
}
