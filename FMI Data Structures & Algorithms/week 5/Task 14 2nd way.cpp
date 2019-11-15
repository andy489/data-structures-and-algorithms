#include <bits/stdc++.h>

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
  		Node* insert(Node* root, int data) {
            if(root == NULL) {
                return new Node(data);
            } else {
                Node* cur;
                if(data <= root->data) {
                    cur = insert(root->leftNode, data);
                    root->leftNode = cur;
                } else {
                    cur = insert(root->rightNode, data);
                    root->rightNode = cur;
               }

               return root;
           }
        }


	void countLeftRight(Node *root, int& left, int& right) {
       if (root == nullptr) {
           return;
       }
       if (root->leftNode) {
           left++;
           countLeftRight(root->leftNode, left, right);
       }
       if (root->rightNode) {
           right++;
           countLeftRight(root->rightNode, left, right);
       }
   }
    void leftRight(Node *root) {
        int left = 0, right = 0;
       countLeftRight(root, left, right);
       printf("[%d,%d]", left, right);
   }


}; //End of Solution

int main() {
  
    Solution myTree;
    Node* root = NULL;
    
    int t;
    int data;

    std::cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }
  
	myTree.leftRight(root);
    return 0;
}
