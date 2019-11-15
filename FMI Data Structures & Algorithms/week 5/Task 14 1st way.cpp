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


	void leftRight(Node* root)
    {
        queue<Node*>Q;
        Q.push(root);
        while (!Q.empty())
        {
            Node* top = Q.front();
            if (top->leftNode!=nullptr)
            {
                leftCounter++;
                Q.push(top->leftNode);
            }
            if (top->rightNode!=nullptr)
            {
                rightCounter++;
                Q.push(top->rightNode);
            }
            Q.pop();
        }
        cout << "[" << leftCounter << "," << rightCounter << "]\n";
    }
private:
    int leftCounter = 0;
    int rightCounter = 0;


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
