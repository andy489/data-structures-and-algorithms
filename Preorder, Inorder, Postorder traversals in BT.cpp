/* Binary Tree Traversal - Preorder, Inorder, Postorder */
#include<iostream>

struct Node
{
	struct Node *left;
	char data;
	struct Node *right;
};

//Function to visit nodes in Preorder
void Preorder(struct Node *root)
{
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
	if (root == nullptr) return;

	std::cout << root->data << ' '; // Print data
	Preorder(root->left);     // Visit left subtree
	Preorder(root->right);    // Visit right subtree
}

//Function to visit nodes in Inorder
void Inorder(Node *root)
{
	if (root == nullptr) return;

	Inorder(root->left);       //Visit left subtree
	std::cout << root->data << ' ';  //Print data
	Inorder(root->right);      // Visit right subtree
}

//Function to visit nodes in Postorder
void Postorder(Node *root)
{
	if (root == nullptr) return;

	Postorder(root->left);    // Visit left subtree
	Postorder(root->right);   // Visit right subtree
	std::cout << root->data << ' '; // Print data
}

// Function to Insert Node in a Binary Search Tree
Node* Insert(Node *root, char data)
{
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
	//Print Nodes in Preorder. 
	std::cout << "Preorder: ";
	Preorder(root);
	std::cout << "\n";
	//Print Nodes in Inorder
	std::cout << "Inorder: ";
	Inorder(root);
	std::cout << "\n";
	//Print Nodes in Postorder
	std::cout << "Postorder: ";
	Postorder(root);
	std::cout << "\n";
}
