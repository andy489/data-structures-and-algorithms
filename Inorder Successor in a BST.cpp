// github.com/andy489

// Inorder successor in BST 
#include <iostream>

struct Nodev{
	Node *left, *right;
	int data;
};

//Function to find some data in the tree
Node* find(Node*root, int data) {
	if (root == nullptr) return nullptr;
	else if (root->data == data) return root;
	else if (root->data < data) return find(root->right, data);
	else return find(root->left, data);
}

//Function to find Node with minimum value in a BST
Node* findMin(Node* root) {
	if (root == nullptr) return nullptr;
	while (root->left != nullptr)
		root = root->left;
	return root;
}

//Function to find Inorder Successor in a BST
Node* getSuccessor(Node* root, int data) {
	// Search the Node - O(h)
	Node* current = find(root, data);
	if (current == nullptr) return current;
	if (current->right != nullptr) { //Case 1: Node has right subtree
		return findMin(current->right); // O(h)
	}
	else { //Case 2: No right subtree  - O(h)
		Node* successor = nullptr;
		Node* ancestor = root;
		while (ancestor != current) {
			if (current->data < ancestor->data) {
				successor = ancestor;
				// so far this is the deepest node for which current node is in left
				ancestor = ancestor->left;
			}
			else
				ancestor = ancestor->right;
		}
		return successor;
	}
}

//Function to visit nodes in Inorder
void Inorder(Node *root) {
	if (root == nullptr) return;

	Inorder(root->left);       //Visit left subtree
	std::cout << root->data << ' ';  //Print data
	Inorder(root->right);      // Visit right subtree
}

// Function to Insert Node in a Binary Search Tree
Node* Insert(Node *root, int data) {
	if (root == nullptr) {
		root = new Node();
		root->data = data;
		root->left = root->right = nullptr;
	}
	else if (data <= root->data)
		root->left = Insert(root->left, data);
	else
		root->right = Insert(root->right, data);
	return root;
}

int main() {
	/*Code To Test the logic
	  Creating an example tree
			    5
			   / \
			  3   10
			 / \   \
			1   4   11
	*/
	Node* root = nullptr;
	root = Insert(root, 5); root = Insert(root, 10);
	root = Insert(root, 3); root = Insert(root, 4);
	root = Insert(root, 1); root = Insert(root, 11);

	//Print Nodes in Inorder
	std::cout << "Inorder Traversal: ";
	Inorder(root);
	std::cout << "\n";

	// Find Inorder successor of some node. 
	Node* successor = getSuccessor(root, 10);
	if (successor == nullptr) std::cout << "No successor Found\n";
	else
		std::cout << "Successor is " << successor->data << "\n";
}
