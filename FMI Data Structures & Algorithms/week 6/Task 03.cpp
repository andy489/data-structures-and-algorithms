#define CAP 500001 // because vector count starts from 0 and we do not need it
#include <iostream> 
#include <vector> // for add function and results (fast selection O(1))
#include <queue> // for display function

struct Node
{
	int data;
	Node* left, * right, * parent;
	Node(int data, Node* parent = nullptr) :left(nullptr), right(nullptr), data(data), parent(parent) {};
};

class BinaryTree
{
public:
	Node* root;
	Node** nodes;
	BinaryTree()
	{
		nodes = new Node * [CAP]; // all will be nullptr
		for (size_t i = 0; i < CAP; i++)
		{
			nodes[i] = nullptr;
		}
		this->root = new Node(1);
		nodes[1] = root;
	}
	bool addCheck(int parentData, int childData)
	{
		Node* indx = nodes[parentData];
		if (indx)  // if it isn't nullptr (it has node in that position)
		{
			if (!indx->left) // if it has no left child
			{
				Node* leftChild = new Node(childData, indx);
				nodes[childData] = leftChild;
				indx->left = leftChild;
				return true;
			}
			else if (!indx->right)
			{
				Node* rightChild = new Node(childData, indx);
				nodes[childData] = rightChild;
				indx->right = rightChild;
				return true;
			}
			else
			{
				return false; // Error: Node is full
			}
		}
		else
		{
			return false; // Can not add to unexisting Node
		}
	}

	void add(int x, int y)
	{
		if (!addCheck(x, y))
		{
			addCheck(y, x);
		}
	}
	// first way - traverse to the k-th ancestor using parent connection 
	Node* getAncestor_k(int data, int k)
	{
		Node* traversal = nodes[data];
		if (traversal)
		{
			for (int i = 0; i < k; i++)
			{
				traversal = traversal->parent; // O(k)
			}
			return traversal;
		}
		else return traversal; // same as return nullptr;
	}

	Node* help = nullptr; // help = prev, prev, ... and so on k times
	// second way - without using parent extension. Using only the power of DFS algorithm
	Node* DFS(Node* root, int data, int& k) // Time complexity: O(n), n - number of nodes
	{
		if (!root) return nullptr;

		if (root->data == data || (help = DFS(root->left, data, k)) || (help = DFS(root->left, data, k)))
		{
			if (k > 0) k--;
			else if (k == 0)
			{
				return root;
			}
		}
		return root; // return to help
	}

	Node* getAncestorDFS_k(int data, int k)
	{
		Node* ancestor(DFS(root, data, k));
		return ancestor;
	}

	void display()  //DLR (Data-Left-Right)
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
				if (Q.front() == nullptr)
				{
					return; // if there are two consecutive nullptr in the queue
				}
				std::cout << '\n';
			}
			else
			{
				if (current->left != nullptr)
				{
					Q.push(current->left);
				}
				if (current->right != nullptr)
				{
					Q.push(current->right);
				}
				std::cout << current->data << " ";
				Q.pop();
			}

		}
	}
};

int main()
{
	int N; std::cin >> N;

	BinaryTree BT;

	for (int i = 1; i < N; i++)
	{
		int x, y; std::cin >> x >> y;
		BT.add(x, y);

	}
	//BT.display();
	int K;std::cin >> K;

	std::vector<int> answers1(K);
	std::vector<int> answers2(K);

	for (int i = 0; i < K; i++)
	{
		int x, y;  std::cin >> x >> y;
		if (x >= 1 && BT.nodes[x])
		{
			//first way
			Node* ancestor = BT.getAncestor_k(x, y);
			answers1[i] = ancestor->data;
			//second way
			Node* ancestorDFS = BT.getAncestorDFS_k(x, y);
			answers2[i] = ancestor->data;
		}
		else
		{
			answers1[i] = -1;
			answers2[i] = -1;
		}
	}

	for (auto i : answers1)
	{
		if (i == -1) std::cout << "Error! There is no such node in the tree\n";
		else std::cout << i << '\n';
	}
	for (auto i : answers2)
	{
		if (i == -1) std::cout << "Error! There is no such node in the tree\n";
		else std::cout << i << '\n';
	}

	return 0;
}
