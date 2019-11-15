#include <iostream>
using namespace std;

class Node {
public:
	int data;
	Node* leftNode;
	Node* rightNode;
	Node(int d) {
		data = d;
		leftNode = NULL;
		rightNode = NULL;
	}
};

class Solution {
public:
	Node* insert(Node* root, int data) {
		if (root == NULL) {
			return new Node(data);
		}
		else {
			Node* cur;
			if (data <= root->data) {
				cur = insert(root->leftNode, data);
				root->leftNode = cur;
			}
			else {
				cur = insert(root->rightNode, data);
				root->rightNode = cur;
			}

			return root;
		}
	}

	void print(Node* root,bool isRoot=1) {
		if (root) {
			print(root->rightNode, 0);
			print(root->leftNode, 0);
			if (isRoot) {
				cout << root->data;
			}
			else {
				cout << root->data<<';';
			}
		}
	}
}; 

int main() {

	Solution myTree;
	Node* root = NULL;

	int t;
	int data;

	std::cin >> t;

	while (t-- > 0) {
		std::cin >> data;
		root = myTree.insert(root, data);
	}

	myTree.print(root);
	return 0;
}
