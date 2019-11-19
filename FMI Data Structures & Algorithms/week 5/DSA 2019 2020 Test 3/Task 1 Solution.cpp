#include <iostream>
using namespace std;

struct Node{
    Node *left;
    Node *right;
    int value;
    Node(int value){
        this->value = value;
        this->left = NULL;
        this->right = NULL;
    }
};

class BST{

public:
    BST(){
        root = NULL;
    }
    void insert(int value){
        root = insert(root, value);
    }

    void DLR(Node* root, int dividedBy)
    {
        if(!root) return;
        if(root->value%dividedBy ==0 && (root->left!=nullptr || root->right!=nullptr) )
        {
            cout<<root->value<<' ';
        }
        DLR(root->left,dividedBy);
        DLR(root->right,dividedBy);
        
    }
    
	void printSpecific(int dividedBy){
        display(root,dividedBy);
    }

private:
	// you can implemented helper functions if you want

    Node* root;

    Node* insert(Node *curNode, int value){
        if(curNode == NULL){
            curNode =  new Node(value);
        }else if(curNode->value < value){
            curNode->right = insert(curNode->right, value);
        }else if(curNode->value > value){
            curNode->left = insert(curNode->left, value);
        }else {
        	//if we already have this value at the tree - do nothing
        }
        return curNode;
    }
};
int main() {
    int n;
  	cin >> n;
  	int value;
  	BST tree;
  	for(int i = 0 ; i < n; i++){
      cin >> value;
      tree.insert(value);
    }
  	int dividedBy;
  	cin >> dividedBy;
  	tree.printSpecific(dividedBy);
    return 0;
}
