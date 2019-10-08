/* Vertical Order Traversal */
#include <iostream>
#include <map>
#include <vector>
#include <algorithm> // just for sorting vector

struct Node
{
	Node* left, * right;
	int data;
	Node(int data) : left(nullptr), right(nullptr), data(data) {};
};

Node* add(Node* root, short data)
{ // BST add like function just for testing the code
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

void verticalOrderTraversal(Node* root, int hd, std::map<int, std::vector<int>>& M)
{	// Algorithm - (Level Order Traversal + Hash Table (Map))
	if (root == nullptr) return; // Base case
	M[hd].push_back(root->data); // for every hd there is a vector of int (type of data for Node) 

								 //Filling the Map:
	verticalOrderTraversal(root->left, hd - 1, M);
	verticalOrderTraversal(root->right, hd + 1, M);
}

void displayVerticalOrder(Node* root)
{
	std::map<int, std::vector<int>> M;
	int hd = 0;
	verticalOrderTraversal(root, 0, M);

	for (auto i : M)
	{
		// if we want to sort vectors with node datas before printing
		sort(i.second.begin(),i.second.end()); 
		for (auto j : i.second)
		{
			std::cout << j << ' ';
		}
		std::cout << '\n';
	}

	/*//second way of printing using iterators:
	std::map< int, std::vector<int> > ::iterator it;
	for (it = M.begin(); it != M.end(); it++)
	{
		sort(it->second.begin(), it->second.end());
		for (int i = 0; i < it->second.size(); ++i)
		{
			std::cout << it->second[i] << " ";
		}
		std::cout << '\n';
	}*/
}

int main()
{
	Node* root = nullptr;
	std::cout << "Enter count of Nodes: ";short countNodes;std::cin >> countNodes;
	short i(0), data; std::cout << "Enter data for nodes to be inserted: ";
	for (; i < countNodes; ++i)
	{
		std::cin >> data;
		root = add(root, data);
	}
	displayVerticalOrder(root);

	return 0;
}
