/* Binary tree - Level Order Traversal */
#include<iostream>
#include<queue>

struct Node 
{
	Node *left;
	char data;	
	Node *right;
};

Node* getNewNode(char data)
{
	Node* newNode = new Node();
	newNode->data = data;
	newNode->left = newNode->right = nullptr;
	return newNode;
}

// Function to print Nodes in a binary tree in Level order
void LevelOrder(Node *root)  //DLR (Data-Left-Right)
{
	if (root == nullptr) return;
	std::queue<Node*> Q;
	Q.push(root);
	//while there is at least one discovered node
	while (!Q.empty()) 
	{
		Node* current = Q.front();
		Q.pop(); // removing the element at front
		std::cout << current->data << " ";
		if (current->left != nullptr) Q.push(current->left);
		if (current->right != nullptr) Q.push(current->right);
	}
}
// Function to Insert Node in a Binary Search Tree
Node* Insert(Node *root, char data) 
{
	if (root == nullptr) root = getNewNode(data);
	else if (data <= root->data) root->left = Insert(root->left, data);
	else root->right = Insert(root->right, data);
	return root;
}

int main() 
{
	/*Code To Test the logic
	  Creating an example tree
			    M
			   / \
			  B   Q
			 / \   \
			A   C   Z
	*/
	Node* root = nullptr;
	root = Insert(root, 'M'); root = Insert(root, 'B');
	root = Insert(root, 'Q'); root = Insert(root, 'Z');
	root = Insert(root, 'A'); root = Insert(root, 'C');
	//Print Nodes in Level Order. 
	LevelOrder(root);
}
