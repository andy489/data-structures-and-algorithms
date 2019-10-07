#include <iostream>
#include <stack>
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

void topView(Node* root)
{
	std::stack<int> S;
	Node* leftTraverse = root;
	Node* rightTraverse = root;
	while (leftTraverse->left!=nullptr)
	{
		S.push(leftTraverse->left->data);
		leftTraverse = leftTraverse->left;
	}
	while (!S.empty())
	{
		std::cout << S.top() << ' ';
		S.pop();
	}
	std::cout << root->data << ' ';
	while (rightTraverse->right != nullptr)
	{
		std::cout << rightTraverse->right->data << ' ';
		rightTraverse = rightTraverse->right;
	}
}

int main()
{
	Node* root = nullptr;
	unsigned countNodes;std::cin >> countNodes;
	int data,i(0); std::cout << "Enter data for nodes to be inserted: ";
	for (; i < countNodes; ++i)
	{
		std::cin >> data;
		root = add(root, data);
	}
	std::cout << "Top view:\n"; topView(root);
	return 0;
}

