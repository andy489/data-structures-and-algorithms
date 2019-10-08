/* Binary tree - Level Order Traversal - Single Line Sequence Print */
#include<iostream>
#include<queue>

struct Node
{
	Node* left, * right;
	char data;
	Node(int data) :left(nullptr), right(nullptr), data(data) {};
};

// Function to print Nodes in a binary tree in Level order
void LevelOrder(Node* root)  //DLR (Data-Left-Right)
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
Node* Insert(Node* root, char data)
{
	if (root == nullptr) root = new Node(data);
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
-------------------------------------------------------------------------------------------------------------------------------
/* Binary tree - Level Order Traversal - Level by Level */
#include<iostream>
#include<queue>

struct Node
{
	Node* left, * right;
	char data;
	Node(char data) :left(nullptr), right(nullptr), data(data) {};
};

// Function to print Nodes in a binary tree in Level order
void LevelOrder(Node* root)  //DLR (Data-Left-Right)
{
	if (root == nullptr) return;
	std::queue<Node*> Q;
	Q.push(root);
	Q.push(nullptr); // whenever a level is over we will insert nullptr
	//while there is at least one discovered node
	while (!Q.empty())
	{
		Node* current = Q.front();

		if (current == nullptr)
		{
			Q.pop(); // removing the element at front			
			Q.push(nullptr); // takes care of the next level
			if (Q.front()==nullptr)
			{
				return; // if there are two consecutive nullptr in the queue
			}
			std::cout << '\n';
		}
		else
		{
			if (current->left != nullptr) Q.push(current->left);
			if (current->right != nullptr) Q.push(current->right);
			std::cout << current->data << " ";
			Q.pop(); 	
		}
			   		 
	}
}
// Function to Insert Node in a Binary Search Tree
Node* Insert(Node* root, char data)
{
	if (root == nullptr) root = new Node(data);
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
	
