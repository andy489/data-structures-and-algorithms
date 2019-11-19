#include <iostream>
#include <queue>
using namespace std;

struct Node {
	Node* left;
	Node* right;
	int value;
	Node(int value) {
		this->value = value;
		this->left = NULL;
		this->right = NULL;
	}
};

class BST {

public:
	BST() {
		root = NULL;
	}

	void insert(int value) {
		root = insert(root, value);
	}

	void BFS(Node* root, int k)
	{
		if (k==0)
		{
			cout << root->value;
			return;
		}
		int level = 1;
		if (root == nullptr) return;
		queue<Node*>Q, ans;
		Q.push(root);
		while (!Q.empty())
		{
			int SIZE = (int)Q.size();
			Node* temp;
			while (SIZE--)
			{
				temp = Q.front();
				Q.pop();

				if (temp->right)  Q.push(temp->right);
				if (temp->left)  Q.push(temp->left);
				if (k == level)
				{
					if (temp->right)  ans.push(temp->right);
					if (temp->left)  ans.push(temp->left);
				}				
			}level++;
		}
		while (!ans.empty())
		{
			cout << ans.front()->value << ' ';ans.pop();
		}
	}

	void printKDistant(int k) {
		BFS(root, k);
	}

private:
	//you can write helper functions if needed
	Node* root;

	Node* insert(Node* curNode, int value) {
		if (curNode == NULL) {
			curNode = new Node(value);
		}
		else if (curNode->value < value) {
			curNode->right = insert(curNode->right, value);
		}
		else if (curNode->value > value) {
			curNode->left = insert(curNode->left, value);
		}
		else {
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
	for (int i = 0; i < n; i++) {
		cin >> value;
		tree.insert(value);
	}
	int k;
	cin >> k;
	tree.printKDistant(k);
	return 0;
}
