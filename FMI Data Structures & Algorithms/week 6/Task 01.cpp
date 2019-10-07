#include <iostream>

struct Node
{
	int data;
	Node* left, * right;
	Node(int data) :left(nullptr), right(nullptr), data(data) {};
};

Node* add(Node* root, int data)
{
	if (root == nullptr)
	{
		root = new Node(data);
	}
	else if (data <= root->data)
	{
		root->left = add(root->left, data);
	}
	else
	{
		root->right = add(root->right, data);
	}
	return root;
}

int height(Node* root)
{
	if (root == nullptr) return -1;
	else
	{
		int leftHeight = height(root->left);
		int rightHeight = height(root->right);
		if (leftHeight > rightHeight) return(leftHeight + 1);
		else return(rightHeight + 1);
	}
}


int main()
{
	Node* root = nullptr;
	unsigned countNodes;std::cin >> countNodes;
	unsigned i(0), data; std::cout << "Enter data for nodes to be inserted: ";
	for (; i < countNodes; ++i)
	{
		std::cin >> data;
		root = add(root, data);
	}
	std::cout << "Height of BST is: " << height(root) << '\n';
	return 0;
}
