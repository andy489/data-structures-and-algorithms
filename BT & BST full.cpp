//Binary Search Tree (BST) - Implementation in C++
#include <iostream>
#include <string>

struct BstNode
{
	BstNode* left;
	int data;
	BstNode* right;
};

BstNode* getNewNode(int data)
{
	BstNode* newNode = new BstNode();//BstNode* newNode=(BstNode*)malloc(sizeof(BstNode)); 
	newNode->data = data;//(*newNode).data = data;
	newNode->left = newNode->right = nullptr;
	return newNode;
}

BstNode* insert(BstNode* root, int data)
{
	if (root == nullptr)//empty tree
	{   //case: 1
		root = getNewNode(data);
	}
	else if (data <= root->data)
	{	//case: 2
		root->left = insert(root->left, data);//recursive call
	}
	else
	{	//case: 3
		root->right = insert(root->right, data);
	}
	return root;
}

bool search(BstNode* root, int data)
{
	if (root == nullptr) return false;
	else if (root->data == data) return true;
	else if (data <= root->data)
	{	//search left subtree
		return search(root->left, data);//recursive call
	}
	else
	{	//search right subtree
		return search(root->right, data);
	}
}

BstNode* minValueAddressNode(BstNode* root)
{	// recursive
	if (root == nullptr||root->left == nullptr) return root;
	return minValueAddressNode(root->left);
}

BstNode* minValAddNode(BstNode* root)
{	// iterative
	if (root == nullptr) return root;
	while (root->left != nullptr)
	{
		root = root->left;
	}
	return root;
}

BstNode* maxValueAddressNode(BstNode* root)
{	// recursive
	if (root == nullptr||root->right == nullptr) return root;
	return maxValueAddressNode(root->right);
}

BstNode* remove(BstNode* root, int data)
{
	if (root == nullptr) return root;
	else if (data < root->data) root->left = remove(root->left, data);
	else if (data > root->data) root->right = remove(root->right, data);
	else//we found it, now we must delete it
	{
		if (root->left == nullptr && root->right == nullptr)
		{	//case 1: no child
			delete root;
			root = nullptr;
		}
		else if (root->left == nullptr) //one child
		{  	//case 2.1: right child
			BstNode* temp = root;
			root = root->right;
			delete temp;
		}
		else if (root->right == nullptr)
		{	//case 2.2: left child
			BstNode* temp = root;
			root = root->left;
			delete temp;			
		}
		else//case 3: two children
		{
			BstNode* temp = minValueAddressNode(root->right);//findMax(root->left)
			root->data = temp->data;
			root->right = remove(root->right, temp->data);
		}
	}
	return root;
}

int findHeightOfBinaryTree(BstNode* root) // works for BT also. Time complexity O(n)
{	// we are counting edges (right definition)
	if (root == nullptr) return -1;
	//return max(findHeightOfBinaryTree(root->left), findHeightOfBinaryTree(root->right));
	int leftHeight = findHeightOfBinaryTree(root->left);
	int rightHeight = findHeightOfBinaryTree(root->right);
	return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
}

bool isBstUtil(BstNode* root, int minValue, int maxValue)
{
	if (root == nullptr) return true;
	if (root->data > minValue && root->data < maxValue
		&& isBstUtil(root->left, minValue, root->data)
		&& isBstUtil(root->right, root->data, maxValue)) return true;
	else return false;
}

bool isBinarySearchTree(BstNode* root)
{
	return isBstUtil(root, INT_MIN, INT_MAX);
}

void print(BstNode* root, int leftLim, int rightLim)
{
	if (root == nullptr) return;// base case	
	//If value of root's key is greater than leftLim, then recursively call in left subtree
	if (leftLim < root->data) print(root->left, leftLim, rightLim);
	// If value of root's key is in range, then print the root's key
	if (leftLim <= root->data && rightLim >= root->data) std::cout << root->data << " ";
	//If value of root's key is smaller than krightLim, then recursively call in right subtree
	if (rightLim > root->data) print(root->right, leftLim, rightLim);
}
void helpMenu()
{
	std::cout << "Functionality in BST\n";
	std::cout << "A - Insert node with key\n";
	std::cout << "S - Search for node with key\n";
	std::cout << "M - Finds node with max/min data\n";
	std::cout << "F - Finds Height of BT\n";
	std::cout << "? - Checks whether a tree is BST\n";
	std::cout << "P - Print in Range as Array\n";
	std::cout << "X - Delete node with key\n";
	std::cout << "H - Help (Menu)\n";
	std::cout << "Q - Quit\n";
}

void test()
{
	BstNode* root = nullptr; //To store address of root node. 
						//This is pointer to root and not the root itself. 
						//Initially setting the root to NULL, 
						//to say that the tree is empty 
	helpMenu();
	while (1)
	{
		char command;
		std::cout << "Enter command: ";
		std::cin >> command;
		if (command == 'Q') break;
		switch (command)
		{
		case 'A':
		{
			int data;
			std::cout << "Enter data (int) of node to be added to BST: ";
			std::cin >> data;
			root = insert(root, data);
			break;
		}
		case 'S':
		{
			int data;
			std::cout << "Enter a key of node to be searched: ";
			std::cin >> data;
			search(root, data) ? std::cout << "~found\n" : std::cout << "~not found\n";
			break;
		}
		case 'X':
		{
			int data;
			std::cout << "Enter key of node to be deleted: ";
			std::cin >> data;
			remove(root, data);
			break;
		}
		case 'F':
		{
			std::cout << "Height of BT is: ";
			std::cout << findHeightOfBinaryTree(root) << '\n';
			break;
		}
		case 'M':
		{
			BstNode* minMax;
			std::cout << "What node do you want to seek min or max? ";
			std::string info;
			std::cin >> info;
			if (info == "min")
			{
				minMax = minValAddNode(root);
				if (minMax == nullptr)
				{
					std::cout << "~Tree is empty\n";
					break;
				}
				std::cout << "Node with minimum data is " << minMax->data << "\n";
				break;
			}
			else if (info == "max")
			{
				minMax = maxValueAddressNode(root);
				if (minMax == nullptr)
				{
					std::cout << "~Tree is empty\n";
					break;
				}
				minMax = maxValueAddressNode(root);
				std::cout << "Node with maximum data is " << minMax->data << "\n";
				break;
			}
			else std::cout << "~wrong input\n";
			break;
		}
		case 'P':
		{
			int left, right;
			std::cout << "Left boundary: "; std::wcin >> left;
			std::cout << "Right boundary: "; std::wcin >> right;
			print(root, left, right);
			std::cout << "\n";
			break;
		}
		case '?':
		{
			isBinarySearchTree(root) ? std::cout << "~Tree is BST\n" : std::cout << "~Tree is not BST\n";
			break;
		}
		case 'H':
		{
			helpMenu();
			break;
		}
		case ' ':

		case '\n':

			break;
		default:
			std::cout << "invalid command\n";
		}
	}
}

int main()
{
	test();
	return 0;
}
