// github.com/andy489

#include <iostream>
#include <queue>

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

    void sumLevel(Node *root) {
        if (root == nullptr)
            return;
        queue<Node *> Q;
        Q.push(root);
        c = 1, sumPerRow = root->data;
        while (!Q.empty()) {
            cout << sumPerRow;
            sumPerRow = 0;
            while (c--) {
                Node *curr = Q.front();
                Q.pop();
                if (curr->leftNode)
                    Q.push(curr->leftNode), sumPerRow += curr->leftNode->data;
                if (curr->rightNode)
                    Q.push(curr->rightNode), sumPerRow += curr->rightNode->data;;
            }
            c = Q.size();
            if (c)
                cout << ';';
        }
    }

private:
    int c, sumPerRow;
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
    return myTree.sumLevel(root), 0;
}
