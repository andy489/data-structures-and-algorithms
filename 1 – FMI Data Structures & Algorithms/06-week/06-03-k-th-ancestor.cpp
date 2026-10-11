#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int CAPACITY = 5e+5;

struct Node {
    int data;
    Node *left, *right, *parent;

    explicit Node(int data, Node *parent = nullptr) : left(nullptr), right(nullptr), data(data), parent(parent) {};
};

struct BinaryTree {
    Node *root;
    vector<Node *> *nodes;

    BinaryTree() {
        nodes = new vector<Node *>(CAPACITY, nullptr);
        this->root = new Node(1);
        (*nodes)[1] = root;
    }

    bool addCheck(int parentData, int childData) const {
        Node *indx = (*nodes)[parentData];
        if (indx) {
            if (!indx->left) {
                Node *leftChild = new Node(childData, indx);
                (*nodes)[childData] = leftChild;
                indx->left = leftChild;
                return true;
            } else if (!indx->right) {
                Node *rightChild = new Node(childData, indx);
                (*nodes)[childData] = rightChild;
                indx->right = rightChild;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void add(int x, int y) const {
        if (!addCheck(x, y)) {
            addCheck(y, x);
        }
    }

    // first way – traverse to the k-th ancestor using parent connection
    [[nodiscard]] Node *get_ancestor_k(int data, int k) const {
        Node *traversal = (*nodes)[data];
        if (traversal) {
            for (int i = 0; i < k; i++) {
                traversal = traversal->parent; // O(k)
            }
            return traversal;
        } else {
            return traversal; // same as return nullptr;
        }
    }

    Node *help = nullptr; // help = prev, prev, ... and so on k times
    // second way - without using parent extension. Using only the power of DFS algorithm
    Node *DFS(Node *root, int data, int &k) { // Time complexity: O(n), n - number of nodes
        if (!root) {
            return nullptr;
        }

        if (root->data == data || (help = DFS(root->left, data, k)) || (help = DFS(root->left, data, k))) {
            if (k > 0) {
                --k;
            } else if (k == 0) {
                return root;
            }
        }
        return root; // return to help
    }

    Node *get_ancestor_dfs_k(int data, int k) {
        Node *ancestor(DFS(root, data, k));
        return ancestor;
    }

    void display() {  // DLR (Data-Left-Right)
        if (root == nullptr) return;
        queue<Node *> Q;
        Q.push(root);
        Q.push(nullptr); // whenever a level is over we will insert nullptr
        // while there is at least one discovered node
        while (!Q.empty()) {
            Node *current = Q.front();

            if (current == nullptr) {
                Q.pop(); // removing the element at front
                Q.push(nullptr); // takes care of the next level

                if (Q.front() == nullptr) {
                    return; // if there are two consecutive nullptr in the queue
                }

                cout << endl;
            } else {
                if (current->left != nullptr) {
                    Q.push(current->left);
                }

                if (current->right != nullptr) {
                    Q.push(current->right);
                }

                cout << current->data << " ";
                Q.pop();
            }
        }
    }
};

int main() {
    int n;
    cin >> n;

    BinaryTree BT;

    int x, y;
    for (int i = 1; i < n; ++i) {
        cin >> x >> y;
        BT.add(x, y);
    }
    // BT.display()

    int k;
    cin >> k;

    vector<int> answers1(k), answers2(k);

    for (int i = 0; i < k; ++i) {
        cin >> x >> y;
        if (x >= 1 && BT.nodes + x) {
            //first way
            Node *ancestor = BT.get_ancestor_k(x, y);
            answers1[i] = ancestor->data;

            //second way
            Node *ancestorDFS = BT.get_ancestor_dfs_k(x, y);
            answers2[i] = ancestor->data;
        } else {
            answers1[i] = -1;
            answers2[i] = -1;
        }
    }
    /*
	for (auto i : answers1){
		if (i == -1) {
            cout << "Error! There is no such node in the tree" << endl;
        }
		else {
            cout << i << endl;
        }
	}
	*/

    for (auto i : answers2) {
        if (i == -1) {
            cout << "Error! There is no such node in the tree" << endl;
        } else {
            cout << i << endl;
        }
    }
    
    return 0;
}
